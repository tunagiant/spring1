package com.insight.board.mapper;

import com.insight.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// mybatis매퍼 인터페이스 임을 선언
@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList() throws Exception;
}
