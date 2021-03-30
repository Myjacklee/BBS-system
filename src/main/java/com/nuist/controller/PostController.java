package com.nuist.controller;

import com.nuist.domain.Board;
import com.nuist.domain.Post;
import com.nuist.domain.User;
import com.nuist.service.BoardService;
import com.nuist.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author LiZonggen
 * @date 2021-03-30 20:47
 * @description:版块控制器
 * @version:
 */
@Controller
@RequestMapping(path = "/post")
public class PostController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private PostService postService;
    @RequestMapping(path = "/add/{postId}")
    public String addBoard(Board board, @PathVariable("postId") Integer postId, HttpSession session){
        board.setBbs_section_id(postId);
        User user=(User)session.getAttribute("user");
        board.setUid(user.getUid());
        board.setBoard_create_time(new Timestamp(new Date().getTime()));
        board.setLast_reply_time(new Timestamp(new Date().getTime()));
        boardService.addBoard(board,postId);
        return "redirect:/post/"+postId;
    }
    @RequestMapping(path = "/{postId}")
    public String goPost(Model model, @PathVariable("postId")Integer postId){
        List<Board> allBoard=boardService.findAllBoard(postId);
        Post post=postService.findPostById(postId);
        model.addAttribute("allBoard",allBoard);
        model.addAttribute("post",post);
        return "post";
    }
}
