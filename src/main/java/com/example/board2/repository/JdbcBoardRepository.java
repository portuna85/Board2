package com.example.board2.repository;

import com.example.board2.domain.Board;
import com.example.board2.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class JdbcBoardRepository implements BoardRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> find() {
        StringBuffer sql = new StringBuffer("SELECT c.userIdx, c.title, c.viewCount, c.created FROM content c LEFT JOIN board b on b.contentIdx = c.contentIdx");
        return jdbcTemplate.queryForList(sql.toString());
    }
}