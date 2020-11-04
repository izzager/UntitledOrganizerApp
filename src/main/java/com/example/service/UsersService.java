package com.example.service;

import com.example.entity.Users;
import com.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements IUsersService {
    @Autowired
    public UsersRepository usersRepository;

    public UsersService() {}

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Integer id) {
        return usersRepository.findById(id);
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public Optional<Users> findByLoginAndPass(String login, String pass) {
        return usersRepository.findByLoginAndPass(login, pass);
    }
}
