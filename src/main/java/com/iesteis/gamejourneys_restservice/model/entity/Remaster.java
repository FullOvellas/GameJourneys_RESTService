package com.iesteis.gamejourneys_restservice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Remaster extends Game {

    @ManyToOne
    @JoinColumn(name = "remastered_game_id")
    private Game remasteredGame;

    public Game getRemasteredGame() {
        return remasteredGame;
    }

    public void setRemasteredGame(Game remasteredGame) {
        this.remasteredGame = remasteredGame;
    }
}