package com.iesteis.gamejourneys_restservice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Remake extends Game {

    @ManyToOne
    @JoinColumn(name = "remade_game_id")
    private Game remadeGame;

}