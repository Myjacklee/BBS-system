package com.nuist.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author LiZonggen
 * @date 2021-03-26 22:28
 * @description:拦截器，对用户登录状态进行判读
 * @version:
 */
public class SystemInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //如果是登录页面则放行
        if (httpServletRequest.getRequestURI().indexOf("login") >= 0) {
            return true;
        }
        HttpSession session = httpServletRequest.getSession();
        //用户登录了也放行
        if (session.getAttribute("id") != null) {
            return true;
        }
        //跳转到登录页面
        httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}