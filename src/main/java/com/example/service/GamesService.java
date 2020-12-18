package com.example.service;

import com.example.entity.Games;
import com.example.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamesService {
    @Autowired
    public GamesRepository gamesRepository;

    public GamesService() {}

    public List<Games> findAll() {
        return gamesRepository.findAll();
    }

    public Optional<Games> findByGameName(String gameName) {
        return gamesRepository.findByGameName(gameName);
    }
}
