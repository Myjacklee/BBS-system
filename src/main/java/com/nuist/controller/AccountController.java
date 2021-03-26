package com.nuist.controller;

import com.nuist.domain.Account;
import com.nuist.domain.Register;
import com.nuist.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LiZonggen
 * @date 2021-02-26 19:50
 * @description:账户信息业务层控制器
 * @version:
 */
@Controller
@RequestMapping(path = "/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "/findAll")
    public String findAll(Model model){
        System.out.println("表现层查询所有账户...");
        /*调用service的方法
        * controller放置在容器当中，如果service也放置在容器当中
        * controller就能够调用service
        * */
        List<Account> list= accountService.findAll();
        model.addAttribute("list",list);
        for(Account item:list){
            System.out.println(item);
        }
        return "list";
    }
    @RequestMapping(path = "/save")
    public String save(Account account,Model model) {
        System.out.println("表现层储存用户数据...");
        accountService.saveAccount(account);
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);
        for (Account item : list) {
            System.out.println(item);
        }
        return "list";
    }

}
