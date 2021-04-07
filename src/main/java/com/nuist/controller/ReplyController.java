package com.nuist.controller;

import com.nuist.domain.OperateResult;
import com.nuist.domain.Reply;
import com.nuist.domain.ReplyResult;
import com.nuist.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping(path = "/add/{boardId}/{reply_floor}")
    @ResponseBody
    public ReplyResult addReply(@RequestBody Reply reply, @PathVariable("reply_floor") Integer reply_floor,@PathVariable("boardId") Integer boardId, HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        ReplyResult replyResult=new ReplyResult();

        if(reply.getReply_content().length()>200){
            replyResult.setMessage("fail");
            return replyResult;
        }
        reply.setUid(uid);
        reply.setReply_time(new Timestamp(new Date().getTime()));
        reply.setBoard_id(boardId);
        reply.setReply_target_floor(reply_floor);
        System.out.println(reply);
        Integer result=replyService.addReply(reply);
        replyResult.setFloor(reply.getFloor());
        if(result==1){
            replyResult.setMessage("success");
        }else{
            replyResult.setMessage("fail");
        }
        return replyResult;
    }
    @RequestMapping(path = "/delete/{reply_id}")
    public String deleteReplyByReplyId(@PathVariable("reply_id")Integer replyId, HttpSession session, Model model){
        Integer uid=(Integer) session.getAttribute("uid");
        OperateResult operateResult=new OperateResult();

        if(replyService.deleteReplyByReplyId(replyId,uid)==1) {
            operateResult.setTitle("成功删除回复");
            operateResult.setState("success");
        }else{
            operateResult.setTitle("删除回复失败");
            operateResult.setState("fail");
        }
        model.addAttribute("result",operateResult);
        return "operateResult";
    }
}
