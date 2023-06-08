package com.iesteis.gamejourneys_restservice.model.entity;

import com.iesteis.gamejourneys_restservice.model.Platform;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "releases")
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "game_id")
    Game game;

    @ManyToOne
    @JoinColumn(name = "region_id")
    Region region;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "releases_platforms",
            joinColumns = @JoinColumn(name = "release_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    List<Platform> platforms;

    public Long getId() {
        return id;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Game getGame() {
        return game;
    }

    public Region getRegion() {
        return region;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

}