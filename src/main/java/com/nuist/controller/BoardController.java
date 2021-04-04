package com.nuist.controller;

import com.nuist.domain.Board;
import com.nuist.domain.Reply;
import com.nuist.domain.User;
import com.nuist.service.BoardService;
import com.nuist.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private ReplyService replyService;
    @RequestMapping(path = "{boardId}")
    public String showBoard(@PathVariable("boardId")Integer id, Model model){
        Board board= boardService.findBoardById(id);
        if(board==null){
            model.addAttribute("message","访问的帖子不存在");
            return "error";
        }
        model.addAttribute("board",board);
        List<Reply> allReply=replyService.findAllReply(id);
        model.addAttribute("allReply",allReply);
        return "board";
    }
    @RequestMapping(path = "/add/{postId}")
    @ResponseBody
    public String addBoard(@RequestBody Board board, @PathVariable("postId") Integer postId, HttpSession session){
        System.out.println(board);
        board.setBbs_section_id(postId);
        User user=(User)session.getAttribute("user");
        board.setUid(user.getUid());
        board.setBoard_create_time(new Timestamp(new Date().getTime()));
        board.setLast_reply_time(new Timestamp(new Date().getTime()));
        if(boardService.addBoard(board,postId)==1){
            return "success";
        }else{
            return "fail";
        }

    }
    @RequestMapping("/delete/{boardId}")
    public String deleteBoard(@PathVariable("boardId") Integer boardId,HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        System.out.println(uid);
        boardService.deleteBoardByBoardId(uid,boardId);
        return "redirect:/manage/home";
    }
}
