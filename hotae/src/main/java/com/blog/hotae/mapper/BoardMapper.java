package com.blog.hotae.mapper;

import com.blog.hotae.domain.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {

    public int insertBoard(BoardDTO param);

    public BoardDTO selectBoardDetail(Long idx);

    public int updateBoard(BoardDTO params);

    public int deleteBoard(Long idx);

    public List<BoardDTO> selectBoardList();

    public int selectBoardTotalCount();

}
