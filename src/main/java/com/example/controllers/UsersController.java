package com.example.controllers;

import com.example.entity.Users;
import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getUsers() {
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/users/findByLoginAndPass")
    public ResponseEntity<Users> getUsers(@RequestParam String login,
                                          @RequestParam String pass) {
        Optional<Users> user = usersService.findByLoginAndPass(login, pass);
        return user
                .map(users -> new ResponseEntity<>(users, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
