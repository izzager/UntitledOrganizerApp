package com.example.controllers;

import com.example.entity.User;
import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getUsers() {
        System.out.println(usersService.findAll());
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);
    }
}
