package com.iesteis.gamejourneys_restservice.model.entity;

import com.iesteis.gamejourneys_restservice.model.entity.compositekeys.GameLanguageKey;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "games_languages")
public class GameLanguage {

    @EmbeddedId
    private GameLanguageKey id;

    @ManyToOne
    @MapsId("languageId")
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id")
    private Game game;

    private boolean texts;

    @Column(name = "voice_acting")
    private boolean voiceActing;

    private boolean subtitles;

}
