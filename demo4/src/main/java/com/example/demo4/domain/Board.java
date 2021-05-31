package com.example.demo4.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private Long idx;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createDate;
    private Long readCount;
    private Long memberId;

}
