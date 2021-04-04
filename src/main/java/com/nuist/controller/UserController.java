package com.nuist.controller;

import com.nuist.domain.Board;
import com.nuist.domain.User;
import com.nuist.domain.RegisterCheckRes;
import com.nuist.exception.SysException;
import com.nuist.service.BoardService;
import com.nuist.service.UserService;
import org.omg.PortableInterceptor.INACTIVE;
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
 * @date 2021-03-17 12:23
 * @description:用户控制器
 * @version:
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BoardService boardService;
    @RequestMapping(path = "/goRegister")
    public String goRegister(){
        return "register";
    }
    @RequestMapping(path = "/goLogin")
    public String goLogin(HttpSession session){
        System.out.println(session);
        return "login";
    }

    @RequestMapping(path="/register")
    public String register(User user,Model model)  throws SysException{

        try{
            if(user.isEmpty()){
                return "register";
            } else if(userService.registerCheck(user)==0){
                Integer result= userService.register(user);
                return "login";

            }else{
                model.addAttribute("user",user);
                model.addAttribute("message","该邮箱已被注册账号，请更换邮箱注册");
                return "register";
            }
        }catch (Exception e){
           throw new SysException("注册出现错误，请联系系统管理员");
        }
    }
    @RequestMapping(path="/checkEmail")
    public @ResponseBody
    RegisterCheckRes register2(@RequestBody User user)  throws SysException{
        RegisterCheckRes rcs=new RegisterCheckRes();
        try{
            if(userService.registerCheck(user)!=0){
                rcs.setRes("该邮箱已被注册，请跟换邮箱注册");
            }else{
                rcs.setRes("邮箱未被注册，可以正常注册");
            }
        }catch (Exception e){
            rcs.setRes("注册出现错误，请联系系统管理员");
        }finally {
            return rcs;
        }
    }

    @RequestMapping(path = "/logout")
    public String logout(HttpSession session) {
       // session.removeAttribute("uid");
//        销毁了再次浏览还是会创建新的session
        session.invalidate();
        return "login";
    }


    @RequestMapping(path = "/login")
    public String login(User user, HttpSession session, Model model){
        System.out.println(user);
        if(user.isEmpty()){
            return "login";
        }
        User result=userService.login(user);
        if(result!=null){
            session.setAttribute("uid",result.getUid());
            session.setAttribute("user",result);
            System.out.println(result);
            return "redirect:/home/index";
        }else{
            model.addAttribute("message","输入的账号或密码错误，请重新输入");
            model.addAttribute("email",user.getEmail());
            model.addAttribute("password",user.getPassword());
            return "login";
        }
    }


}
