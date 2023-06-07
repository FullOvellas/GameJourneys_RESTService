package com.iesteis.gamejourneys_restservice.model.entity.compositekeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GamePersonKey implements Serializable {

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "game_id")
    private Long gameId;

}
