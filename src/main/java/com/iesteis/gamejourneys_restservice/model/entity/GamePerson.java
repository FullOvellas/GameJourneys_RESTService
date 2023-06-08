package com.iesteis.gamejourneys_restservice.model.entity;

import com.iesteis.gamejourneys_restservice.model.entity.compositekeys.GamePersonKey;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "games_people")
public class GamePerson {

    @EmbeddedId
    private GamePersonKey id;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public GamePersonKey getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public Game getGame() {
        return game;
    }

    public Role getRole() {
        return role;
    }
}
