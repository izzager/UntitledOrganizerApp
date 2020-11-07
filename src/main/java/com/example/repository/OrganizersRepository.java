package com.example.repository;

import com.example.entity.Organizers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrganizersRepository extends JpaRepository<Organizers, Integer> {
    List<Organizers> findAllByIdGame(int idGame);
    List<Organizers> findAll();
    Optional<Organizers> findByNameOrgAndIdGame(String nameOrg, Integer idGame);
}
