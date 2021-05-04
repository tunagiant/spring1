package com.example.demo4.controller;

import com.example.demo4.domain.Board;
import com.example.demo4.domain.Criteria;
import com.example.demo4.domain.PageMaker;
import com.example.demo4.domain.SearchCriteria;
import com.example.demo4.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/boards/**")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

//    @GetMapping("/main")
//    public String main(Model model) {
//        model.addAttribute("list", boardService.boardList(criteria));
//        return "/boards/main";
//    }
    @GetMapping("/main/{pageNum}")
    public String main(@PathVariable int pageNum, Model model, Criteria criteria) {
        criteria.setPage(pageNum);
        model.addAttribute("list", boardService.boardList(criteria));
        model.addAttribute("pageNum", pageNum);

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(criteria);
        pageMaker.setTotalCount(boardService.boardCount());
        model.addAttribute("pageMaker", pageMaker);

        return "/boards/main";
    }

    @GetMapping("/{boardId}/view")
    public String viewBoard(Model model, @PathVariable Long boardId) {
        boardService.readCountBoard(boardId);
        model.addAttribute("view", boardService.getBoard(boardId));
        return "/boards/view";
    }

    @GetMapping("/upload")
    public String uploadBoardForm() {
        return "/boards/upload";
    }

    @PostMapping("/upload")
    public String uploadBoard(Board board, RedirectAttributes redirectAttributes) {
        boardService.uploadBoard(board);
        redirectAttributes.addAttribute("status", true);
        return "redirect:/boards/upload";
    }

    @GetMapping("/{boardId}/update")
    public String updateBoardForm(@PathVariable Long boardId, Model model) {
        Board updateBoard = boardService.getBoard(boardId);
        model.addAttribute("board", updateBoard);
        return "/boards/update";
    }

    @PostMapping("/{boardId}/update")
    public String updateBoard(Board board, RedirectAttributes redirectAttributes) {
        boardService.updateBoard(board);
        redirectAttributes.addAttribute("status", true);
        return "redirect:/boards/{boardId}/update";
    }

    @GetMapping("/{boardId}/delete")
    public String deleteBoardForm(@PathVariable Long boardId, Model model) {
        Board deleteBoard = boardService.getBoard(boardId);
        model.addAttribute("board", deleteBoard);
        return "/boards/delete";
    }

    @PostMapping("/{boardId}/delete")
    public String deleteBoard(@PathVariable Long boardId, RedirectAttributes redirectAttributes) {
        boardService.deleteBoard(boardId);
        redirectAttributes.addAttribute("status", true);
        return "redirect:/boards/{boardId}/delete";
    }


}
