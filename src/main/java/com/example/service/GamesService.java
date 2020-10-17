package com.example.service;

import com.example.entity.Games;
import com.example.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesService implements IGamesService {
    @Autowired
    public GamesRepository gamesRepository;

    public GamesService() {}

    @Override
    public List<Games> findAll() {
        return gamesRepository.findAll();
    }
}
