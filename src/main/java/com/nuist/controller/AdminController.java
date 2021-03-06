package com.nuist.controller;

import com.nuist.domain.Admin;
import com.nuist.domain.Message;
import com.nuist.domain.Post;
import com.nuist.domain.PostAdmin;
import com.nuist.service.AdminService;
import com.nuist.service.MessageService;
import com.nuist.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.xml.xpath.XPath;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author LiZonggen
 * @date 2021-03-29 11:19
 * @description:管理员控制层
 * @version:
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private PostService postService;
    @Autowired
    private MessageService messageService;
    @RequestMapping(path = "/login")
    public String login(Admin admin, HttpSession session, Model model){
        if(admin.isEmpty()){
            return "adminHome";
        }
        if(adminService.login(admin)==1){
            session.setAttribute("admin",admin);
            return "redirect:/admin/home";
        }else{
            model.addAttribute("message","账号或密码错误");
            return "adminLogin";
        }
    }
    @RequestMapping(path = "/goLogin")
    public String goLogin(){
        return "adminLogin";
    }
    @RequestMapping(path = "/logout")
    public String logout(HttpSession session) {
        // session.removeAttribute("uid");
//        销毁了再次浏览还是会创建新的session
        session.invalidate();
        return "adminLogin";
    }
    @RequestMapping(path = "/home")
    public String goHome(Model model){
        List<Post> list=postService.findAllPost();
        model.addAttribute("postList",list);
        return "adminHome";
    }
    @RequestMapping(path = "/addPost")
    public String addPost(Post post){
        postService.addPost(post);
        return "redirect:/admin/home";
    }
    @RequestMapping(path = "/setPostAdmin")
    @ResponseBody
    public String setPostAdmin(@RequestBody PostAdmin postAdmin){
        Integer result=adminService.setPostAdmin(postAdmin);
        if(result==1){
            String postName=postService.findPostById(postAdmin.getPostId()).getSection_name();
            Message message=new Message();
            message.setMessage_time(new Timestamp(new Date().getTime()));
            message.setMessage_url("/post/"+postAdmin.getPostId());
            message.setMessage_content("超级管理员已将您设置为了"+postName+"版块的管理员");
            message.setSender_uid(1);
            message.setTarget_uid(postAdmin.getUid());
            messageService.addMessage(message);
            return "success";
        }else if(result==2){
            return "contain";
        }else{
            return "fail";
        }
    }
}
