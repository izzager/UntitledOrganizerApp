package com.example.controllers;

import com.example.entity.Games;
import com.example.entity.Organizers;
import com.example.service.GamesService;
import com.example.service.OrganizersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class GameOrganizersController {

    private final GamesService gamesService;
    private final OrganizersService organizersService;

    @Autowired
    public GameOrganizersController(GamesService gamesService, OrganizersService organizersService) {
        this.gamesService = gamesService;
        this.organizersService = organizersService;
    }

    @GetMapping("/organizersByGameName")
    public ResponseEntity<List<Organizers>> getOrganizers(@RequestParam String gameName) {
        Optional<Games> idGame = gamesService.findByGameName(gameName);
        if (idGame.isPresent()) {
            List<Organizers> organizers = organizersService.findAllByIdGame(idGame.get().getId());
            if (!organizers.isEmpty()) {
                return new ResponseEntity<>(organizers, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/gamesWithOrgs")
    public ResponseEntity<HashMap<String, ArrayList<Organizers>>> getGamesWithOrgs() {
        List<Games> games = gamesService.findAll();
        List<Organizers> organizers = organizersService.findAll();
        HashMap<String, ArrayList<Organizers>> response = new HashMap<>();
        for (Organizers org: organizers) {
            String gameName = games.get(org.getIdGame()).getGame_name();
            if (!response.containsKey(gameName)) {
                response.put(gameName, new ArrayList<>());
            }
            response.get(gameName).add(org);
        }
        //System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
