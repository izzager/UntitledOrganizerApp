package com.example.controllers;

import com.example.entity.Games;
import com.example.entity.Organizers;
import com.example.service.GamesService;
import com.example.service.OrganizersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/organizers")
    public ResponseEntity<List<Organizers>> getOrganizers(@RequestParam(value = "idGame") int idGame) {
        organizersService.findAllByIdGame(idGame)
                .forEach(System.out::println);
        List<Organizers> organizers = organizersService.findAllByIdGame(idGame);
        if (organizers.isEmpty()) {
            return new ResponseEntity<>(organizers, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(organizers, HttpStatus.OK);
        }
    }

}
