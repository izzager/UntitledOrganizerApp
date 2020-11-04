package com.example.repository;

import com.example.entity.Components;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComponentsRepository extends JpaRepository<Components, Integer> {
    List<Components> findAll();
    Optional<List<Components>> findAllByIdOrganizer(int idOrganizer);
}
