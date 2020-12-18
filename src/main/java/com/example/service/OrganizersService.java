package com.example.service;

import com.example.entity.Organizers;
import com.example.repository.OrganizersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizersService {
    @Autowired
    public OrganizersRepository organizerRepository;

    public OrganizersService() {}

    public List<Organizers> findAllByIdGame(int idGame) {
        return organizerRepository.findAllByIdGame(idGame);
    }

    public List<Organizers> findAll() {
        return organizerRepository.findAll();
    }

    public Optional<Organizers> findByNameOrgAndIdGame(String nameOrg, Integer idGame) {
        return organizerRepository.findByNameOrgAndIdGame(nameOrg, idGame);
    }
}
