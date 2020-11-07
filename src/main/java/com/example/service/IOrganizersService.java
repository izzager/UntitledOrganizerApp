package com.example.service;

import com.example.entity.Organizers;

import java.util.List;
import java.util.Optional;

public interface IOrganizersService {
    List<Organizers> findAllByIdGame(int idGame);
    List<Organizers> findAll();
    Optional<Organizers> findByNameOrgAndIdGame(String nameOrg, Integer idGame);
}
