package com.nuist.service;

import com.nuist.domain.User;

public interface UserService {
    //检查账号是否重复
    public Integer registerCheck(User user);
    //进行注册
    public Integer register(User user);
    //进行登录
    public User login(User user);
}
