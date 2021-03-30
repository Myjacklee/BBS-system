package com.nuist.controller;

import com.nuist.domain.Board;
import com.nuist.domain.Post;
import com.nuist.domain.User;
import com.nuist.service.BoardService;
import com.nuist.service.PostService;
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
@RequestMapping(path = "/index")
public class HomeController {
    @Autowired
    private PostService postService;
    @Autowired
    private BoardService boardService;
    @RequestMapping(path = "/home")
    public String goHome(Model model){
        List<Post> list= postService.findAllPost();
        model.addAttribute("postList",list);
        return "home";
    }


}
