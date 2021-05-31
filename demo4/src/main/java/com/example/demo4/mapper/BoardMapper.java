package com.example.demo4.mapper;

import com.example.demo4.domain.Board;
import com.example.demo4.domain.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BoardMapper {

    int boardCount();

    List<Board> getList(Criteria criteria);

    Board getBoard(Long idx);

    void uploadBoard(Board board);

    void updateBoard(Board board);

    void readCountBoard(Long idx);

    void deleteBoard(Long idx);

}
