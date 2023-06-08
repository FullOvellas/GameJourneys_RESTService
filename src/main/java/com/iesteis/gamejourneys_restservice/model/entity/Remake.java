package com.iesteis.gamejourneys_restservice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Remake extends Game {

    @ManyToOne
    @JoinColumn(name = "remade_game_id")
    private Game remadeGame;

    public Game getRemadeGame() {
        return remadeGame;
    }

    public void setRemadeGame(Game remadeGame) {
        this.remadeGame = remadeGame;
    }
}