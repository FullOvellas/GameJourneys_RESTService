package com.iesteis.gamejourneys_restservice.model.entity.compositekeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GamePersonKey implements Serializable {

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "game_id")
    private Long gameId;

    public Long getPersonId() {
        return personId;
    }

    public Long getGameId() {
        return gameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamePersonKey that = (GamePersonKey) o;
        return Objects.equals(personId, that.personId) && Objects.equals(gameId, that.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, gameId);
    }
}
