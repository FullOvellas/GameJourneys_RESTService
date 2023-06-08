package com.iesteis.gamejourneys_restservice.repository;

import com.iesteis.gamejourneys_restservice.model.entity.Game;
import com.iesteis.gamejourneys_restservice.model.entity.GamePerson;
import com.iesteis.gamejourneys_restservice.model.entity.compositekeys.GamePersonKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GamePersonRepository extends JpaRepository<GamePerson, GamePersonKey> {
    List<GamePerson> findByGame(Game game);
}