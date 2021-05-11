package com.nuist.controller;

import com.nuist.domain.Board;
import com.nuist.domain.OperateResult;
import com.nuist.domain.Reply;
import com.nuist.domain.User;
import com.nuist.service.BoardService;
import com.nuist.service.ReplyService;
import com.nuist.service.UserService;
import com.sun.org.apache.bcel.internal.generic.FSUB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
        User user=userService.findUserByUid((Integer) session.getAttribute("uid"));
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
        User user=userService.findUserByUid((Integer) session.getAttribute("uid"));
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
        User user=userService.findUserByUid((Integer) session.getAttribute("uid"));
        List<Reply> allReply=replyService.findReplyByUid(user.getUid());
        model.addAttribute("allReply",allReply);
        model.addAttribute("page",3);
        model.addAttribute("userInformation",user);

        return "manageBoardReply";
    }

    @RequestMapping("/upload")
    public String upload(HttpSession session, MultipartFile userHead,Model model) throws Exception {
        OperateResult res=new OperateResult();
        Integer uid=(Integer) session.getAttribute("uid");
        String fileName=userHead.getOriginalFilename();
        String suffix=fileName.substring(fileName.lastIndexOf(".")+1);
        if(!("png".equals(suffix)||"jpg".equals(suffix)||"jpeg".equals(suffix))){
            res.setMessage("只允许上传png、jpg、jpeg格式的文件！");
            res.setTitle("操作结果");
            res.setState("fail");
            model.addAttribute("result",res);
            return "operateResult";
        }
        String path=session.getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        File file=new File(path);
        if(!file.exists()){
            file.mkdir();
        }

        String uuid= UUID.randomUUID().toString().replace("-","");
        fileName=uuid+fileName.substring(fileName.lastIndexOf("."));
        userHead.transferTo(new File(path,fileName));
        userService.setHeadURL(uid,fileName);
        res.setMessage("上传头像成功");
        res.setTitle("操作结果");
        res.setState("success");
        model.addAttribute("result",res);
        return "operateResult";
    }

    @RequestMapping(path = "/updateUser")
    @ResponseBody
    public String updateUser(@RequestBody User user, HttpSession session){
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
        return "redirect:/manage/home/boardManage";
    }
}
