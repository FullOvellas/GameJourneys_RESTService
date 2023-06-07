package com.iesteis.gamejourneys_restservice.model.entity.compositekeys;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class GameLanguageKey implements Serializable {

    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "game_id")
    private Long gameId;

}
