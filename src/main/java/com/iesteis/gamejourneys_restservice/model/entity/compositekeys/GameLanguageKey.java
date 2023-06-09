package com.iesteis.gamejourneys_restservice.model.entity.compositekeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GameLanguageKey implements Serializable {

    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "game_id")
    private Long gameId;

    public Long getLanguageId() {
        return languageId;
    }

    public Long getGameId() {
        return gameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameLanguageKey that = (GameLanguageKey) o;
        return Objects.equals(languageId, that.languageId) && Objects.equals(gameId, that.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageId, gameId);
    }
}
