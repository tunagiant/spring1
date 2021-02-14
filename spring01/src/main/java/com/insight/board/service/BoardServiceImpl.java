package com.insight.board.service;


import com.insight.board.dto.BoardDto;
import com.insight.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    // 데이터베이스에 접근하는 DAO빈 선언
    @Autowired
    private BoardMapper boardMapper;


    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        // BoardMapper클래스의 selectBoardList메서드 호출
        return boardMapper.selectBoardList();
    }
}
