package com.example.board2.domain;

// 게시물 리스트(목록) 클래스
public class Board {
    private long userIdx;
    private long contentIdx;

    private long boardIdx;

    public Board() {
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

    public long getBoardIdx() {
        return boardIdx;
    }

    public void setBoardIdx(long boardIdx) {
        this.boardIdx = boardIdx;
    }
}