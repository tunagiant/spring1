package com.insight.board.dto;

import lombok.Data;

@Data   // 롬복 : getter, setter, toString, hashCode, equals메서드 생성
public class BoardDto {
    private int boardIdx;
    private String title;
    private String contents;
    private int hitCnt;
    private String creatorId;
    private String createdDatetime;
    private String updaterId;
    private String updatedDatetime;


}
