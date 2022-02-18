package com.example.board2.repository;

import com.example.board2.domain.Content;
import com.example.board2.domain.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class JdbcContentRepository implements ContentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 게시글 내용 입력 - OK
    @Override
    public int writeContent(Content content) {
        StringBuffer sql = new StringBuffer("INSERT INTO board_test_db.content (userIdx, contentIdx, title, text, viewCount, created) VALUES (?, null, ?, ?, ?, now())");
        Object[] obj = {content.getUserIdx(), content.getTitle(), content.getText(), content.getViewCount()};
        return jdbcTemplate.update(sql.toString(), obj);
    }

    // 게시글에 댓글  입력 - OK
    @Override
    public int writeReply(Reply reply) {
        StringBuffer sql = new StringBuffer("INSERT INTO board_test_db.reply (userIdx, contentIdx, text, created) VALUES (?, ?, ?, now())");
        Object[] obj = new Object[]{reply.getUserIdx(), reply.getContentIdx(), reply.getText()};
        return jdbcTemplate.update(sql.toString(), obj);
    }

    // 게시글 내용만 조회 - OK
    @Override
    public Content showContent(Integer idx) {
        return jdbcTemplate.queryForObject("SELECT c.userIdx, c.contentIdx, c.title, c.text, c.viewCount, c.created FROM board_test_db.content c WHERE c.contentIdx = ?",
                BeanPropertyRowMapper.newInstance(Content.class), idx);
    }

    // 게시글의 댓글 출력
    @Override
    public List<Map<String, Object>> showReply(Integer idx) {
        StringBuffer sql = new StringBuffer("SELECT r.userIdx, r.contentIdx, r.text, r.created FROM reply r LEFT JOIN content c on r.contentIdx = c.contentIdx WHERE r.contentIdx = ?;");
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString(), idx);
        return list;
    }

    // 게시물 목록 조회
    @Override
    public List<Map<String, Object>> findAll() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM board_test_db.content");
        return list;
    }
}