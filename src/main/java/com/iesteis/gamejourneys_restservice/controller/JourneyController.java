package com.iesteis.gamejourneys_restservice.controller;

import com.iesteis.gamejourneys_restservice.model.dto.Journey;
import com.iesteis.gamejourneys_restservice.model.dto.mapper.JourneyMapper;
import com.iesteis.gamejourneys_restservice.service.GameListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/journeys")
public class JourneyController {

    private final GameListService gameListService;
    private final JourneyMapper journeyMapper;

    public JourneyController(GameListService gameListService, JourneyMapper journeyMapper) {
        this.gameListService = gameListService;
        this.journeyMapper = journeyMapper;
    }

    @GetMapping("/journey")
    public Journey getJourney(@RequestParam("id") Long id) throws Exception {
        return journeyMapper.toJourney(gameListService.findById(id));
    }

}
