package com.iesteis.gamejourneys_restservice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "game_name", nullable = false)
    private String name;

    private boolean spinoff;

    @ManyToMany()
    @JoinTable(
            name = "games_developers",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id")
    )
    private List<Developer> developers;

    @ManyToMany
    @JoinTable(
            name = "games_genres",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "games_series",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "series_id")
    )
    private List<Series> series;

    @OneToMany(mappedBy = "game")
    private List<Release> releases;

    @OneToMany(mappedBy = "remadeGame")
    private List<Remake> remakes;

    @OneToMany(mappedBy = "remasteredGame")
    private List<Remaster> remasters;

    @ManyToMany
    @JoinTable(
            name = "games_tags",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpinoff() {
        return spinoff;
    }

    public void setSpinoff(boolean spinoff) {
        this.spinoff = spinoff;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

    public List<Remake> getRemakes() {
        return remakes;
    }

    public void setRemakes(List<Remake> remakes) {
        this.remakes = remakes;
    }

    public List<Remaster> getRemasters() {
        return remasters;
    }

    public void setRemasters(List<Remaster> remasters) {
        this.remasters = remasters;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
