package com.iesteis.gamejourneys_restservice.service;

import com.iesteis.gamejourneys_restservice.model.entity.Game;
import com.iesteis.gamejourneys_restservice.repository.GameRepository;
import com.iesteis.gamejourneys_restservice.service.exception.GameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game findGameById(Long gameId) throws GameNotFoundException {
        return gameRepository
                .findById(gameId)
                .orElseThrow(() -> new GameNotFoundException("A game with the requested id could not be found"));
    }

    public List<Game> findByDeveloper(Long developerId) {
        return gameRepository
                .findByDevelopers_Id(developerId);
    }

    public List<Game> findGamesByDeveloperCountry(Long countryId) {
        return gameRepository
                .findByDevelopers_Country_Id(countryId);
    }

}
