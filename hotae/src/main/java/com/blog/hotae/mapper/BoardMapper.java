package com.blog.hotae.mapper;

import com.blog.hotae.domain.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {

    int insertBoard(BoardDTO params);

    BoardDTO selectBoardDetail(Long idx);

    int updateBoard(BoardDTO params);

    int deleteBoard(Long idx);

    List<BoardDTO> selectBoardList();

    int selectBoardTotalCount();

}
