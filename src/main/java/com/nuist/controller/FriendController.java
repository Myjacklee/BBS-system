package com.nuist.controller;

import com.nuist.domain.*;
import com.nuist.service.FriendService;
import com.nuist.service.MessageService;
import com.nuist.service.UserService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiZonggen
 * @date 2021-04-02 10:07
 * @description:好友前端控制器
 * @version:
 */
@Controller
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @RequestMapping("/goFriend")
    public String goFriend(Model model,HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        List<Friend> allFriends=friendService.findAllFriends(uid);
        model.addAttribute("allFriends",allFriends);
        List<FriendAddRequest> allRequest=friendService.getMessage(uid);
        List<Friend> recommendList=friendService.friendRecommend(uid);
        model.addAttribute("allRequest",allRequest);
        model.addAttribute("recommendList",recommendList);
        return "friend";
    }
    @RequestMapping("/findFriend")
    @ResponseBody
    public List<Friend> findFriend(@RequestBody Friend friend){
        List<Friend> result= friendService.findFriend(friend);
        return result;
    }
    @RequestMapping(path = "/addFriend/{friendUid}")
    @ResponseBody
    public String addFriend(@PathVariable("friendUid") Integer receiverUid, HttpSession session){
        Integer senderUid=(Integer) session.getAttribute("uid");
        if(senderUid==receiverUid){
            return "reject";
        }
        Integer result=friendService.addFriend(senderUid,receiverUid);
        if(result==1){
            return "success";
        }else if(result==2){
            return "contain";
        }else{
            return "fail";
        }
    }
    @RequestMapping(path = "/delete/{friendId}")
    public String deleteFriend(@PathVariable("friendId") Integer friendId,HttpSession session,Model model){
        Integer uid=(Integer) session.getAttribute("uid");
        User user=(User) session.getAttribute("user");
        Integer result=friendService.deleteFriendById(friendId,uid);
        if(result==0){
            model.addAttribute("message","你与该用户已不是好友关系，删除失败");
            return "error";
        }
        Message message=new Message();
        message.setMessage_time(new Timestamp(new Date().getTime()));
        message.setMessage_url("/friend/goFriend");
        message.setMessage_content(user.getNickname()+"（账号："+uid+"）已与您解除好友关系");
        message.setSender_uid(uid);
        message.setTarget_uid(friendId);
        messageService.addMessage(message);
        OperateResult operateResult=new OperateResult();
        operateResult.setState("success");
        operateResult.setMessage("您已成功与账号（"+friendId+"）解除好友关系");
        model.addAttribute("result",operateResult);
        return "operateResult";
    }

    @RequestMapping(path = "/response/{md5_code}/{request_id}/{states}/{senderUid}")
    public String dealWithRequest(@PathVariable("senderUid") Integer senderUid, Model model,@PathVariable("request_id") Integer request_id,@PathVariable("md5_code") String md5_code,@PathVariable("states") Integer states,HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        FriendAddRequest friendAddRequest=new FriendAddRequest();
        friendAddRequest.setMd5_code(md5_code);
        friendAddRequest.setRequest_id(request_id);
        friendAddRequest.setStates(states);
        friendAddRequest.setReceiver_uid(uid);
        friendAddRequest.setUid(senderUid);
        OperateResult operateResult=new OperateResult();
        Integer result=friendService.dealWithRequest(friendAddRequest);
        if(result==1){
            operateResult.setTitle("成功接收请求");
            operateResult.setMessage("您与该用户已是好友关系");
            operateResult.setState("success");
            model.addAttribute("result",operateResult);
            System.out.println("成功接收");
        }else if(result==0){
            operateResult.setTitle("拒绝好友请求");
            operateResult.setMessage("您拒绝了用户的好友请求");
            operateResult.setState("fail");
            model.addAttribute("result",operateResult);
            System.out.println("已经拒绝");
        }else{
            operateResult.setTitle("处理异常");
            operateResult.setMessage("您已处理过该请求");
            operateResult.setState("fail");
            model.addAttribute("result",operateResult);
        }
        return "operateResult";
    }
}
