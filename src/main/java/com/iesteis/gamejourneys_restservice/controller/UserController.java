package com.iesteis.gamejourneys_restservice.controller;

import com.iesteis.gamejourneys_restservice.model.entity.User;
import com.iesteis.gamejourneys_restservice.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<User> getAll() {
        return repository.findAll();
    }

}
