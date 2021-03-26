package com.nuist.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LiZonggen
 * @date 2021-03-21 14:25
 * @description:异常处理器
 * @version:
 */
@Component(value = "sysExceptionResolver")
public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        e.printStackTrace();
        SysException ex=null;
        if(e instanceof SysException){
            ex=(SysException)e;
        }else{
            ex=new SysException("系统正在维护...");
        }
        ModelAndView mv=new ModelAndView();
        mv.addObject("message",ex.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
