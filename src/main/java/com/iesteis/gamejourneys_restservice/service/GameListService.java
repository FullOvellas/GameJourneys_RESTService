package com.iesteis.gamejourneys_restservice.service;

import com.iesteis.gamejourneys_restservice.model.entity.GameList;
import com.iesteis.gamejourneys_restservice.repository.GameListRepository;
import org.springframework.stereotype.Service;

@Service
public class GameListService {

    private final GameListRepository gameListRepository;

    public GameListService(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    public GameList findById(Long id) throws Exception {

        return gameListRepository.findById(id).orElseThrow(() -> new Exception("A list with the specified id could not be found"));

    }

}
