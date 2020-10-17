package com.example.service;

import com.example.entity.Organizers;
import com.example.repository.OrganizersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizersService implements IOrganizersService {
    @Autowired
    public OrganizersRepository organizerRepository;

    public OrganizersService() {}

    @Override
    public List<Organizers> findAllByIdGame(int idGame) {
        return organizerRepository.findAllByIdGame(idGame);
    }
}
