package com.nuist.dao;

import com.nuist.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    //查询是否已注册账号
    @Select("select count(*) from user where email=#{email}")
    public Integer registerCheck(User user);
    @Insert("insert into user(email,password,username,nickname,school,college,class,sign_date) value(#{email},#{password},#{username},#{nickname},#{school},#{college},#{studentClass},#{sign_date})")
    @SelectKey(keyColumn = "uid",keyProperty = "uid",resultType = String.class,before = false,statement = "select last_insert_id()")
//    查询到的uid被注入到了keyProperty.uid里面，下方函数返回的值是受影响的结果的条数，成功返回1，失败返回0
    public Integer register(User user);
    @Select("select * from user where email=#{email} and password=#{password}")
    public User login(User user);
}
