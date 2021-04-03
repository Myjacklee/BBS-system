package com.nuist.controller;

import com.nuist.domain.Friend;
import com.nuist.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    @RequestMapping("/goFriend")
    public String goFriend(Model model,HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        List<Friend> allFriends=friendService.findAllFriends(uid);
        model.addAttribute("allFriends",allFriends);
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

    @RequestMapping(path = "/getMessage")
    @ResponseBody
    public List<Friend> getMessage(HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        return friendService.getMessage(uid);
    }
    @RequestMapping(path = "/response/{friendUid}/{states}")
    @ResponseBody
    public String dealWithRequest(@PathVariable("states") Integer states,@PathVariable("friendUid") Integer sender,HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        if(friendService.dealWithRequest(sender,uid,states)==1){
            return "success";
        }else{
            return "fail";
        }
    }
}