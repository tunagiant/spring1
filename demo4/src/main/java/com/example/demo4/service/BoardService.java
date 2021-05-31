package com.example.demo4.service;

import com.example.demo4.domain.Board;
import com.example.demo4.domain.Criteria;
import com.example.demo4.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class BoardService {
    private final BoardMapper boardMapper;

    public int boardCount() {
        return boardMapper.boardCount();
    }

    public List<Board> boardList(Criteria criteria) {
        return boardMapper.getList(criteria);
    }

    public Board getBoard(Long idx) {
        return boardMapper.getBoard(idx);
    }

    public void uploadBoard(Board board) {
        boardMapper.uploadBoard(board);
    }

    @Transactional
    public void updateBoard(Board board) {
        boardMapper.updateBoard(board);
    }

    @Transactional
    public void readCountBoard(Long idx) {
        boardMapper.readCountBoard(idx);
    }

    @Transactional
    public void deleteBoard(Long idx) {
        boardMapper.deleteBoard(idx);
    }

}
