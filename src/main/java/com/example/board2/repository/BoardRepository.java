package com.example.board2.repository;

import com.example.board2.domain.Board;
import com.example.board2.domain.Content;

import java.util.List;
import java.util.Map;

public interface BoardRepository {
    // 게시글 조회
    List<Map<String, Object>> find();
}