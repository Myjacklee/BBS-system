package com.nuist.controller;

import com.nuist.domain.Board;
import com.nuist.service.BoardService;
import com.nuist.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LiZonggen
 * @date 2021-03-30 11:32
 * @description:帖子控制器
 * @version:
 */
@Controller
@RequestMapping(path = "/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @RequestMapping(path = "{boardId}")
    public String showBoard(@PathVariable("boardId")Integer id, Model model){
        Board board= boardService.findBoardById(id);
        model.addAttribute("board",board);
        return "board";
    }
}
