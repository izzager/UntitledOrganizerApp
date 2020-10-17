package com.example.repository;

import com.example.entity.Games;
import com.example.entity.Organizers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizersRepository extends JpaRepository<Organizers, Integer> {
    List<Organizers> findAllByIdGame(int idGame);
}
