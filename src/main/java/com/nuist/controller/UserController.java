package com.nuist.controller;

import com.nuist.domain.User;
import com.nuist.domain.RegisterCheckRes;
import com.nuist.exception.SysException;
import com.nuist.service.UserService;
import netscape.security.UserTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author LiZonggen
 * @date 2021-03-17 12:23
 * @description:用户控制器
 * @version:
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path="/register")
    public @ResponseBody
    RegisterCheckRes register(@RequestBody User user)  throws SysException{
        RegisterCheckRes rcs=new RegisterCheckRes();
        try{
            if(userService.registerCheck(user)==0){
                Integer result= userService.register(user);
                System.out.println("uid:"+result);
                rcs.setRes("成功插入,当前用户的uid为："+ user.getUid());
            }else{
                rcs.setRes("已有数据");
            }
        }catch (Exception e){
            rcs.setRes("注册出现错误，请联系系统管理员");
        }finally {
            return rcs;
        }
    }

    @RequestMapping(path = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login.jsp";
    }

    @RequestMapping(path = "/goLogin")
    public String goLogin(HttpSession session){
        System.out.println(session);
        return "login";
    }
    @RequestMapping(path = "/login")
    public String login(User user, HttpSession session, Model model){
        User result=userService.login(user);
        if(result!=null){
            session.setAttribute("uid",result.getUid());
            session.setAttribute("user",result);
            System.out.println(result);
            return "success";
        }else{
            model.addAttribute("message","输入的账号或密码错误，请重新输入");
            model.addAttribute("email",user.getEmail());
            model.addAttribute("password",user.getPassword());
            return "login";
        }
    }

}
