package com.nuist.controller;

import com.nuist.domain.Board;
import com.nuist.domain.Message;
import com.nuist.domain.Post;
import com.nuist.domain.User;
import com.nuist.service.BoardService;
import com.nuist.service.MessageService;
import com.nuist.service.PostService;
import com.nuist.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.xml.xpath.XPath;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author LiZonggen
 * @date 2021-03-29 14:55
 * @description:主页控制器
 * @version:
 */
@Controller("homeController")
@RequestMapping(path = "/home")
public class HomeController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private BoardService boardService;
    @Autowired
    private MessageService messageService;
    @RequestMapping(path = "/index")
    public String goHome(Model model,HttpSession session){
        List<Post> list= postService.findAllPost();
        model.addAttribute("postList",list);
        return "home";
    }
    @RequestMapping(path = "/{uid}")
    public String visitUserHome(@PathVariable("uid") Integer uid,Model model){
        User user= userService.findUserByUid(uid);
        if(user==null) {
            model.addAttribute("message", "访问的页面不存在");
            return "error";
        }else{
            List<Board> allBoard=boardService.findBoardByUid(uid);
            model.addAttribute("allBoard",allBoard);
            model.addAttribute("user",user);
            return "userHomeDisplay";
        }

    }


}
