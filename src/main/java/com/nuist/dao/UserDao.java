package com.nuist.dao;

import com.nuist.domain.Register;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    //查询是否已注册账号
    @Select("select count(*) from user where email=#{email}")
    public Integer registerCheck(Register register);
    @Insert("insert into user(email,password,username,nickname,school,college,class,sign_date) value(#{email},#{password},#{username},#{nickname},#{school},#{college},#{studentClass},#{sign_date})")
    public void register(Register register);
}
