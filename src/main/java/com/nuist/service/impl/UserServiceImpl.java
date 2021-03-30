package com.nuist.service.impl;

import com.nuist.dao.UserDao;
import com.nuist.domain.User;
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
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public Integer registerCheck(User user) {
        return userDao.registerCheck(user);
    }

    @Override
    public Integer register(User user) {
        user.setSign_date(new Date());
        Integer result=userDao.register(user);
        return result;
    }

    @Override
    public User login(User user) {
        User result=userDao.login(user);
        return result;
    }


}
