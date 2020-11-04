package com.example.controllers;

import com.example.entity.Components;
import com.example.service.ComponentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ComponentsController {
    private final ComponentsService componentsService;

    @Autowired
    public ComponentsController(ComponentsService componentsService) {
        this.componentsService = componentsService;
    }

    @GetMapping("/components")
    public ResponseEntity<List<Components>> getAllComponents() {
        return new ResponseEntity<>(componentsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/components/findAllByIdOrganizer")
    public ResponseEntity<List<Components>> getComponentsByIdOrganizer(@RequestParam int idOrganizer) {
        Optional<List<Components>> components = componentsService.findAllByIdOrganizer(idOrganizer);
        return components
                .map(componentsList -> new ResponseEntity<>(componentsList, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
