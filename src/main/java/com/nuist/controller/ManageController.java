package com.nuist.controller;

import com.nuist.domain.Board;
import com.nuist.domain.Reply;
import com.nuist.domain.User;
import com.nuist.service.BoardService;
import com.nuist.service.ReplyService;
import com.nuist.service.UserService;
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
 * @date 2021-04-01 15:34
 * @description:用户个人数据管理控制器
 * @version:
 */
@Controller
@RequestMapping(path = "/manage")
public class ManageController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    private UserService userService;
    /**
    * @Author: LiZonggen
    * @Date: 2021/4/4
    * @Description: 个人信息更改
    * @param model:
* @param session:
    * @return: java.lang.String
    */
    @RequestMapping(path = "/home")
    public String goUserHome(Model model, HttpSession session){
        User user=(User)session.getAttribute("user");
        model.addAttribute("userInformation",user);
        model.addAttribute("page",1);
        return "manageUserInformation";
    }
    /**
    * @Author: LiZonggen
    * @Date: 2021/4/4
    * @Description: 个人帖子管理
    * @param model:
* @param session:
    * @return: java.lang.String
    */
    @RequestMapping(path = "/home/boardManage")
    public String goUserHomeBoardManage(Model model, HttpSession session){
        User user=(User)session.getAttribute("user");
        List<Board> allBoard=boardService.findBoardByUid(user.getUid());
        model.addAttribute("allBoard",allBoard);
        model.addAttribute("page",2);
        model.addAttribute("userInformation",user);

        return "manageBoard";
    }
    /**
    * @Author: LiZonggen
    * @Date: 2021/4/4
    * @Description: 个人帖子回复查看
    * @param model:
* @param session:
    * @return: java.lang.String
    */
    @RequestMapping(path = "/home/replayManage")
    public String goUserHomeReplyManage(Model model, HttpSession session){
        User user=(User)session.getAttribute("user");
        List<Reply> allReply=replyService.findReplyByUid(user.getUid());
        model.addAttribute("allReply",allReply);
        model.addAttribute("page",3);
        model.addAttribute("userInformation",user);

        return "manageBoardReply";
    }

    @RequestMapping(path = "/updateUser")
    @ResponseBody
    public String updateUser(@RequestBody User user,HttpSession session){
        User oldUser=(User)session.getAttribute("user");
        System.out.println(user);
        if(oldUser.getPassword().equals(user.getPassword())){
            //获取旧的user信息，对数据进行覆盖
            user.setSign_date(oldUser.getSign_date());
            user.setEmail(oldUser.getEmail());
            user.setUid(oldUser.getUid());
            //如果用户没有输入新密码，则不用新密码覆盖旧密码
            if(user.getNew_password()!=null&&user.getNew_password().length()!=0){
                user.setPassword(user.getNew_password());
            }
            if(1==userService.updateUser(user)){
                session.setAttribute("user",user);
                return "success";
            }else{
                return "fail";
            }

        }else{
            return "notEqual";
        }
    }
    @RequestMapping(path = "/deleteBoard/{boardId}")
    public String deleteBoard(@PathVariable("boardId") Integer boardId,HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        System.out.println(uid);
        boardService.deleteBoardByBoardId(uid,boardId);
        return "redirect:/manage/home";
    }
}
