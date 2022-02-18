package com.example.board2.repository;

import com.example.board2.domain.Content;
import com.example.board2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcUserRepository implements UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User signUp(User user) {
        StringBuffer sql = new StringBuffer("INSERT INTO board_test_db.user(userIdx, id, password, age) VALUES (?, ?, ?)");
        Object[] obj = {user.getId(), user.getPassword(), user.getAge()};
        return new User();
    }
}