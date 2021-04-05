package com.nuist.controller;

import com.nuist.dao.MessageDao;
import com.nuist.domain.Message;
import com.nuist.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LiZonggen
 * @date 2021-04-05 15:12
 * @description:个人消息前端控制器
 * @version:
 */
@Controller
@RequestMapping(path = "/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @RequestMapping(path = "")
    public String goMessageHome(HttpSession session, Model model){
        Integer uid=(Integer) session.getAttribute("uid");
        List<Message> HistoryMessage=messageService.findHistoryMessageByReceiverUid(uid);
        List<Message> newMessage=messageService.findNewMessageByReceiverUid(uid);
        model.addAttribute("newMessage",newMessage);
        model.addAttribute("historyMessage",HistoryMessage);
        return "message";
    }
    @RequestMapping(path = "/getMessage")
    @ResponseBody
    public Integer getMessage(HttpSession session, Model model){
        Integer uid=(Integer) session.getAttribute("uid");
        return messageService.getMessageNumByUid(uid);
    }
}
