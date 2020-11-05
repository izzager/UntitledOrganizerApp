package com.example.repository;

import com.example.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface GamesRepository extends JpaRepository<Games, Integer> {
    Optional<Games> findByGameName(String gameName);
}
