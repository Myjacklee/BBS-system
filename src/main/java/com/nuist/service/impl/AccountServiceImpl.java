package com.nuist.service.impl;

import com.nuist.dao.AccountDao;
import com.nuist.domain.Account;
import com.nuist.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiZonggen
 * @date 2021-02-26 19:47
 * @description:
 * @version:
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("业务层查询所有信息...");
        //持久层调用dao对象，service已经被放置在IOC容器当中了，程序能够帮我们生成dao对象，因此我们需要把生成的对象也放入
        //ioc容器当中
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
        System.out.println("业务层保存账户信息...");
    }
}
