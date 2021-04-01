package com.nuist.controller;

import com.nuist.domain.Comment;
import com.nuist.domain.CommentResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LiZonggen
 * @date 2021-04-01 14:27
 * @description:评论控制器
 * @version:
 */
@Controller
@RequestMapping(path = "/comment")
public class CommentController {
    @RequestMapping(path = "/addCommentToFloor/{replyId}")
    public CommentResult addCommentToFloor(Comment comment, @PathVariable("replyId")Integer replyId){
        CommentResult commentResult=new CommentResult();
        return commentResult;
    }
    @RequestMapping(path = "/addCommentToComment/{commentId}/{replyId}")
    public CommentResult addCommentToComment(Comment comment, @PathVariable("replyId")Integer replyId,@PathVariable("commentId") Integer commentId){
        CommentResult commentResult=new CommentResult();
        return commentResult;
    }
}
