package com.example.service;

import com.example.entity.Users;

import java.util.List;
import java.util.Optional;

public interface IUsersService {
    List<Users> findAll();
    Optional<Users> findById(Integer id);
    Optional<Users> findByUsername(String username);
    Optional<Users> findByLoginAndPass(String login, String pass);
}
