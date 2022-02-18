package com.example.board2.service;

import com.example.board2.domain.Content;
import com.example.board2.repository.JdbcContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    JdbcContentRepository repository;

    public List<Map<String, Object>> getBoardList(Integer boardIdx) {

        // 게시글 index를 이용하여 게시글 획득
        Content content = repository.showContent(boardIdx);

        // 게시글 index를 이용하여 게시글의 댓글 획득
        List<Map<String, Object>> list = repository.showReply(boardIdx);

        return list;
    }

}