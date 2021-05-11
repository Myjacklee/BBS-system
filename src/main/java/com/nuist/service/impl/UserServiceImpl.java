package com.nuist.service.impl;

import com.nuist.dao.UserDao;
import com.nuist.domain.User;
import com.nuist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User findUserByUid(Integer uid) {
        return userDao.findUserByUid(uid);
    }

    @Override
    public Integer setHeadURL(Integer uid, String url) {
        return userDao.setHeadURL(uid,url);
    }


}
