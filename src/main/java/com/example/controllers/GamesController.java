package com.example.controllers;

import com.example.entity.Games;
import com.example.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GamesController {

    private final GamesService gamesService;

    @Autowired
    public GamesController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    @PostMapping("/games")
    public ResponseEntity<List<Games>> getGames() {
        gamesService.findAll()
                        .forEach(System.out::println);
        return new ResponseEntity<>(gamesService.findAll(), HttpStatus.OK);
    }
}
