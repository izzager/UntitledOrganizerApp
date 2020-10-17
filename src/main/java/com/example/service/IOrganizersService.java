package com.example.service;

import com.example.entity.Organizers;

import java.util.List;

public interface IOrganizersService {
    List<Organizers> findAllByIdGame(int idGame);
}
