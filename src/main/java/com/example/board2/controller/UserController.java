package com.example.board2.controller;

import com.example.board2.domain.User;
import com.example.board2.repository.JdbcUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    JdbcUserRepository jdbcUserRepository;

    @PostMapping(value = "/signup")
    public User signUp(@RequestBody User user) {
        return jdbcUserRepository.signUp(user);
    }
}