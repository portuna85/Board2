package com.example.board2.controller;

import com.example.board2.domain.Content;
import com.example.board2.domain.Reply;
import com.example.board2.repository.JdbcBoardRepository;
import com.example.board2.repository.JdbcContentRepository;
import com.example.board2.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/v2")
public class BoardController {
    @Autowired
    JdbcBoardRepository jdbcBoardRepository;

    @Autowired
    JdbcContentRepository jdbcContentRepository;

    @Autowired
    BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<String> createContent(@RequestBody Content content) {

        try {
            jdbcContentRepository.writeContent(content);
            return new ResponseEntity<>("", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/reply")
    public ResponseEntity<String> createReply(@RequestBody Reply reply) {
        try {
            jdbcContentRepository.writeReply(reply);
            return new ResponseEntity<>("", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/boards")
    public List<Map<String, Object>> boardList() {
        List<Map<String, Object>> list = jdbcBoardRepository.find();
        return list;
    }

    @GetMapping("/content/{conetentId}")
    public Content content(@RequestParam Integer conetentId) {
        return null;
    }

    @GetMapping("/contents")
    public List<Content> contentList() {
        return null;
    }

}