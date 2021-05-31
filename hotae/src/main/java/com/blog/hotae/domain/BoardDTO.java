package com.blog.hotae.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDTO {

    private Long idx;
    private String title;
    private String content;
    private String writer;
    private int viewCnt;
    private String noticeYn;
    private String secretYn;
    private String deleteYn;
    private LocalDateTime insertTime;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;

}
