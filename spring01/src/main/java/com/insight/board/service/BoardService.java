package com.insight.board.service;

import com.insight.board.dto.BoardDto;

import java.util.List;


public interface BoardService {

    // 게시글 목록을 조회하는 메서드 호출(목록을 저장하기 위해 리스트 사용)
    List<BoardDto> selectBoardList() throws Exception;

}
