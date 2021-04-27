package com.example.demo4.mapper;

import com.example.demo4.domain.Board;
import com.example.demo4.domain.Criteria;
import com.example.demo4.domain.SearchCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BoardMapper {

    int boardCount();

    List<Board> getList(SearchCriteria criteria);

    Board getBoard(Long boardId);

    void uploadBoard(Board board);

    void updateBoard(Board board);

    void readCountBoard(Long boardId);

    void deleteBoard(Long boardId);

}
