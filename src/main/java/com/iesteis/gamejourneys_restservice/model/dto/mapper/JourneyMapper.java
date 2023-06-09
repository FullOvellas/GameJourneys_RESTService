package com.iesteis.gamejourneys_restservice.model.dto.mapper;

import com.iesteis.gamejourneys_restservice.model.Pair;
import com.iesteis.gamejourneys_restservice.model.dto.Journey;
import com.iesteis.gamejourneys_restservice.model.dto.JourneyNode;
import com.iesteis.gamejourneys_restservice.model.entity.*;
import com.iesteis.gamejourneys_restservice.repository.GamePersonRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Component
public class JourneyMapper {

    private static final int LINK_THRESHOLD = 1;
    private final GamePersonRepository gamePersonRepository;
    private final Function<GamePerson, Pair<Person, RoleType>> mapToPersonRoleTypePair = gamePerson ->
            new Pair<>(gamePerson.getPerson(), gamePerson.getRole().getRoleType());

    public JourneyMapper(GamePersonRepository gamePersonRepository) {
        this.gamePersonRepository = gamePersonRepository;
    }

    public Journey toJourney(GameList gameList) {
        var nodes = toJourneyNodeList(gameList.getGames());
        var linksWeights = calculateLinksAndWeights(gameList.getGames());
        var links = linksWeights.getFirstElement();
        var weights = linksWeights.getSecondElement();


        return new Journey(nodes, links, weights);
    }

    private List<JourneyNode> toJourneyNodeList(List<Game> games) {
        return games
                .stream()
                .map(game -> new JourneyNode(game.getName()))
                .toList();
    }

    private Pair<List<Pair<String, String>>, List<Integer>> calculateLinksAndWeights(List<Game> games) {
        List<Pair<String, String>> links = new ArrayList<>(games.size() * 2);
        List<Integer> weights = new ArrayList<>(games.size() * 2);

        for (int i = 0; i < games.size(); i++) {
            Game g = games.get(i);
            var linksAndWeights = findSimilitudes(g, games.subList(i + 1, games.size()));

            links.addAll(linksAndWeights.getFirstElement());
            weights.addAll(linksAndWeights.getSecondElement());
        }

        return new Pair<>(links, weights);
    }

    private Pair<List<Pair<String, String>>, List<Integer>> findSimilitudes(Game game, List<Game> games) {
        List<Pair<String, String>> links = new ArrayList<>();
        List<Integer> weights = new ArrayList<>();
        List<Pair<Person, RoleType>> staffAndRoleTypes = gamePersonRepository
                .findByGame(game)
                .stream()
                .map(mapToPersonRoleTypePair)
                .toList(); // use dtos

        for (Game g : games) {
            int weight = 0; // TODO paralelizar
            if (g == null || g.equals(game)) continue;

            // matching developers
            weight += g
                    .getDevelopers()
                    .stream()
                    .filter(developerChecking ->
                            game.getDevelopers()
                                    .stream()
                                    .anyMatch(
                                            developer -> Objects.equals(developer.getId(), developerChecking.getId())
                                    )
                    ).count();

            // matching developer countries
            weight += g
                    .getDevelopers()
                    .stream()
                    .map(Developer::getCountry)
                    .filter(countryChecking ->
                            game
                                    .getDevelopers()
                                    .stream()
                                    .map(Developer::getCountry)
                                    .anyMatch(
                                            country -> Objects.equals(country.getId(), countryChecking.getId())
                                    )
                    ).count();

            // matching genres
            weight += g
                    .getGenres()
                    .stream()
                    .filter(genreChecking ->
                            game
                                    .getGenres()
                                    .stream()
                                    .anyMatch(genre -> Objects.equals(genre.getId(), genreChecking.getId()))
                    ).count();

            // matching series
            weight += g
                    .getSeries()
                    .stream()
                    .filter(seriesChecking ->
                            game.getSeries()
                                    .stream()
                                    .anyMatch(series -> Objects.equals(series.getId(), seriesChecking.getId()))
                    ).count() * 1.5;

            // is remake or remaster of game
            if (g instanceof Remake remake) {
                weight += Objects.equals(remake.getRemadeGame().getId(), game.getId()) ? 2 : 0;
            } else if (g instanceof Remaster remaster) {
                weight += Objects.equals(remaster.getRemasteredGame().getId(), game.getId()) ? 2 : 0;
            }

            // matching staff
            weight += gamePersonRepository
                    .findByGame(g) // TODO add caching
                    .stream()
                    .map(mapToPersonRoleTypePair)
                    .mapToDouble(pair -> {
                        for (Pair<Person, RoleType> p : staffAndRoleTypes) {
                            if (Objects.equals(p.getFirstElement().getId(), pair.getFirstElement().getId())) {
                                if (Objects.equals(p.getSecondElement().getId(), pair.getSecondElement().getId())) {
                                    return 1.5;
                                }
                                return 1.0;
                            }
                        }
                        return 0.0;
                    }).sum();

            // matching release years
            weight += g
                    .getReleases()
                    .stream()
                    .map(release -> release.getReleaseDate().getYear())
                    .filter(yearChecking ->
                            game
                                    .getReleases()
                                    .stream()
                                    .map(release ->
                                            release
                                                    .getReleaseDate()
                                                    .getYear()
                                    ).anyMatch(year -> year.equals(yearChecking)))
                    .count();

            // matching platforms
            weight += g
                    .getReleases()
                    .stream()
                    .flatMap(release -> release.getPlatforms().stream())
                    .distinct()
                    .filter(platformChecking -> game
                            .getReleases()
                            .stream()
                            .flatMap(release ->
                                    release
                                            .getPlatforms()
                                            .stream())
                            .anyMatch(
                                    platform -> Objects.equals(platform.getId(), platformChecking.getId())
                            )
                    ).count();

            if (weight >= LINK_THRESHOLD) {
                links.add(new Pair<>(game.getName(), g.getName()));
                weights.add(weight);
            }

        }

        return new Pair<>(links, weights);
    }

}
