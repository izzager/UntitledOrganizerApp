package com.example.controllers;

import com.example.entity.Components;
import com.example.entity.Games;
import com.example.entity.Organizers;
import com.example.service.ComponentsService;
import com.example.service.GamesService;
import com.example.service.OrganizersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrgnanizerComponentsController {
    private final GamesService gamesService;
    private final OrganizersService organizersService;
    private final ComponentsService componentsService;

    @Autowired
    public OrgnanizerComponentsController(GamesService gamesService,
                                          OrganizersService organizersService,
                                          ComponentsService componentsService) {
        this.gamesService = gamesService;
        this.organizersService = organizersService;
        this.componentsService = componentsService;
    }

    @GetMapping("/findComponentsByGameAndOrg")
    public ResponseEntity<List<Components>> getComponentsByGameAndOrg(@RequestParam String gameName,
                                                                      @RequestParam String nameOrg) {
        Optional<Games> idGame = gamesService.findByGameName(gameName);
        if (idGame.isPresent()) {
            Optional<Organizers> idOrganizer = organizersService.findByNameOrgAndIdGame(nameOrg, idGame.get().getId());
            if (idOrganizer.isPresent()) {
                Optional<List<Components>> components = componentsService.findAllByIdOrganizer(idOrganizer.get().getId());
                System.out.println(components);
                return components.map(componentsList -> new ResponseEntity<>(componentsList, HttpStatus.OK))
                                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
