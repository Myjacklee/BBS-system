package com.nuist.controller;

import com.nuist.domain.Reply;
import com.nuist.domain.ReplyResult;
import com.nuist.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.sql.Timestamp;

/**
 * @author LiZonggen
 * @date 2021-03-31 10:26
 * @description:回复功能控制器
 * @version:
 */
@Controller
@RequestMapping(path = "/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @RequestMapping(path = "/add/{boardId}")
    @ResponseBody
    public ReplyResult addReply(@RequestBody Reply reply, @PathVariable("boardId") Integer boardId, HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        reply.setUid(uid);
        reply.setReply_time(new Timestamp(new Date().getTime()));
        reply.setBoard_id(boardId);
        System.out.println(reply);
        Integer result=replyService.addReply(reply);
        ReplyResult replyResult=new ReplyResult();
        replyResult.setFloor(reply.getFloor());
        if(result==1){
            replyResult.setMessage("success");
        }else{
            replyResult.setMessage("fail");
        }
        return replyResult;
    }
}
