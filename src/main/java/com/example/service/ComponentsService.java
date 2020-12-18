package com.example.service;

import com.example.entity.Components;
import com.example.repository.ComponentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentsService {
    @Autowired
    public ComponentsRepository componentsRepository;

    public ComponentsService() {}

    public List<Components> findAll() {
        return componentsRepository.findAll();
    }

    public Optional<List<Components>> findAllByIdOrganizer(int idOrganizer) {
        return componentsRepository.findAllByIdOrganizer(idOrganizer);
    }
}
