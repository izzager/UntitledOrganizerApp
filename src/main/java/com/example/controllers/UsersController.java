package com.example.controllers;

import com.example.entity.Users;
import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("")
    public ResponseEntity<List<Users>> getUsers() {
        System.out.println(usersService.findAll());
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/findByLoginAndPass")
    public ResponseEntity<Users> getUsers(@RequestParam String login,
                                          @RequestParam String pass) {
        Optional<Users> user = usersService.findByLoginAndPass(login, pass);
        return user
                .map(users -> new ResponseEntity<>(users, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
