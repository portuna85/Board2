package com.example.board2.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 게시글 작성 클래스
public class Content {

    private long userIdx;               // 유저 인덱스
    private long contentIdx;            // 작성 인덱스
    private String title;               // 제목
    private String text;                // 내용
    private int viewCount;              // 조회수
    private Date created = new Date();     // 작성 날짜

    public List<Reply> replies = new ArrayList<>();

    public Content() {
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public long getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(long userIdx) {
        this.userIdx = userIdx;
    }

    public long getContentIdx() {
        return contentIdx;
    }

    public void setContentIdx(long contentIdx) {
        this.contentIdx = contentIdx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}