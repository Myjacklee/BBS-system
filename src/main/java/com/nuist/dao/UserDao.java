package com.nuist.dao;

import com.nuist.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface UserDao {
    //查询是否已注册账号
    @Select("select count(*) from user where email=#{email}")
    public Integer registerCheck(User user);
    @Insert("insert into user(email,password,username,nickname,school,college,class,sign_date) value(#{email},#{password},#{username},#{nickname},#{school},#{college},#{studentClass},#{sign_date})")
    @SelectKey(keyColumn = "uid",keyProperty = "uid",resultType = Integer.class,before = false,statement = "select last_insert_id()")
//    查询到的uid被注入到了keyProperty.uid里面，下方函数返回的值是受影响的结果的条数，成功返回1，失败返回0
    public Integer register(User user);
    @Select("select * from user where email=#{email} and password=#{password}")
//    解决注解开发当中列名和字段名不一致的问题
    @Results(value = {
            @Result(column = "class" ,property = "studentClass"),
            @Result(column = "head_url",property = "headURL")
    })
    public User login(User user);
    @Update("update user set password=#{password},username=#{username},nickname=#{nickname},school=#{school},college=#{college},class=#{studentClass} where uid=#{uid}")
    public Integer updateUser(User user);
    @Select("select nickname,school,college,uid,class as studentClass,head_url as headURL,email,sign_date,username from user where uid=#{uid}")
    public User findUserByUid(Integer uid);
    @Select("select uid from user")
    public List<Integer> findAllUserUid();
    @Update("update user set head_url=#{url} where uid=#{uid}")
    public Integer setHeadURL(@Param("uid") Integer uid,@Param("url") String url);
}
