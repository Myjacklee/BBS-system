package com.nuist.controller;

import com.nuist.domain.Register;
import com.nuist.domain.RegisterCheckRes;
import com.nuist.exception.SysException;
import com.nuist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    RegisterCheckRes register(@RequestBody Register register)  throws SysException{
        try{
            RegisterCheckRes rcs=new RegisterCheckRes();
            if(userService.registerCheck(register)==0){
                userService.register(register);
                rcs.setRes("成功插入");
            }else{
                rcs.setRes("已有数据");
            }
            return rcs;
        }catch (Exception e){
            throw new SysException("注册出现错误，请联系系统管理员");
        }
    }

    @RequestMapping(path = "/logout")
    private String logout(HttpSession session){
        session.invalidate();
        return "redirect:login.jsp";
    }


}
