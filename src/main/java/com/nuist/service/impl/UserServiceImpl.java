package com.nuist.service.impl;

import com.nuist.dao.UserDao;
import com.nuist.domain.Register;
import com.nuist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author LiZonggen
 * @date 2021-03-17 12:19
 * @description:账号注册实现类
 * @version:
 */
@Service("registerService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public Integer registerCheck(Register register) {
        return userDao.registerCheck(register);
    }

    @Override
    public void register(Register register) {
        register.setSign_date(new Date());
        userDao.register(register);
    }

}
