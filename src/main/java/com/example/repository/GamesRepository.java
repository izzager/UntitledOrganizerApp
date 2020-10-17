package com.example.repository;

import com.example.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GamesRepository extends JpaRepository<Games, Integer> {

}
