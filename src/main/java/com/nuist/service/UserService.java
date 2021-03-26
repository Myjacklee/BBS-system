package com.nuist.service;

import com.nuist.domain.Register;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    //检查账号是否重复
    public Integer registerCheck(Register register);
    //进行注册
    public void register(Register register);
}
