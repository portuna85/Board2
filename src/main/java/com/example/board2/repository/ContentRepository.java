package com.example.board2.repository;

import com.example.board2.domain.Content;
import com.example.board2.domain.Reply;

import java.util.List;
import java.util.Map;

public interface ContentRepository {
    // 게시글 등록
    int writeContent(Content content);

    // 게시글에 댓글 달기
    int writeReply(Reply reply);

    // 게시글 내용 출력
    Content showContent(Integer idx);

    List<Map<String, Object>> showReply(Integer idx);

    List<Map<String, Object>> findAll();
}
