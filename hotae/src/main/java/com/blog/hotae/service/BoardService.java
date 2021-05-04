package com.blog.hotae.service;

import com.blog.hotae.domain.BoardDTO;

import java.util.List;

public interface BoardService {

    boolean registerBoard(BoardDTO params);

    BoardDTO getBoardDetail(Long idx);

    boolean deleteBoard(Long idx);

    List<BoardDTO> getBoardList();
}
