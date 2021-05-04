package com.blog.hotae.controller;

import com.blog.hotae.domain.BoardDTO;
import com.blog.hotae.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board/**")
public class BoardController {

    @Autowired
    private BoardService boardService;

    //신규등록, 수정을 한번에 처리하는 메서드
    @GetMapping("/write.do")
    public String openBoardWrite(@RequestParam(required = false) Long idx, Model model) {
        if (idx == null) {
            model.addAttribute("board", new BoardDTO());
        } else {
            BoardDTO board = boardService.getBoardDetail(idx);
            if (board == null) {
                return "redirect:/board/list.do";
            }
            model.addAttribute("board", board);
        }
        return "board/write";
    }

    @PostMapping("/register.do")
    public String registerBoard(final BoardDTO params) {
        try {
            boolean isRegistered = boardService.registerBoard(params);
            if (isRegistered == false) {
                //게시글등록실패
            }
        } catch (DataAccessException e) {
            //데이터베이스처리과정오류
        } catch (Exception e) {
            //시스템오류
        }

        return "redirect:/board/list.do";
    }
}
