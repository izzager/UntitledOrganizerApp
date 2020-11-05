package com.example.service;

import com.example.entity.Games;

import java.util.List;
import java.util.Optional;

public interface IGamesService {
    List<Games> findAll();
    Optional<Games> findByGameName(String gameName);
}
