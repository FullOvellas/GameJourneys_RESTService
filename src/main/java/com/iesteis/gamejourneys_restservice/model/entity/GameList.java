package com.iesteis.gamejourneys_restservice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "game_lists")
public class GameList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "list_name")
    private String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User listOwner;

    @ManyToMany
    @JoinTable(
            name = "games_game_lists",
            joinColumns = @JoinColumn(name = "game_list_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<Game> games;

}