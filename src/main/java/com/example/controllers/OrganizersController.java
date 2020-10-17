package com.example.controllers;

import com.example.entity.Games;
import com.example.entity.Organizers;
import com.example.service.GamesService;
import com.example.service.OrganizersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrganizersController {
    private final OrganizersService organizersService;

    @Autowired
    public OrganizersController(OrganizersService organizersService) {
        this.organizersService = organizersService;
    }

    @PostMapping("/organizers")
    public ResponseEntity<List<Organizers>> getGames(@RequestParam(defaultValue = "0") int idGame) {
        organizersService.findAllByIdGame(idGame)
                .forEach(System.out::println);
        return new ResponseEntity<>(organizersService.findAllByIdGame(idGame), HttpStatus.OK);
    }

}
