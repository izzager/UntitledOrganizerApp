package com.example.service;

import com.example.entity.Components;

import java.util.List;
import java.util.Optional;

public interface IComponentsService {
    List<Components> findAll();
    Optional<List<Components>> findAllByIdOrganizer(int idOrganizer);
}
