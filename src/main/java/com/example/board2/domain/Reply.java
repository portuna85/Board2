package com.example.board2.domain;

import java.util.Date;

// 게시글의 답글 클래스
public class Reply {
    private long userIdx;
    private long contentIdx;

    private String text;
    private Date created = new Date();

    public Reply() {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}