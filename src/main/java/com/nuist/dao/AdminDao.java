package com.nuist.dao;

import com.nuist.domain.Admin;
import com.nuist.domain.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    @Select("select * from admin where name=#{name} and password=#{password}")
    @Results(value = {
            @Result(column = "admin_id",property = "id")
    })
    public Integer login(Admin admin);
    @Insert("insert into admin(name,password) values(#{name},#{password})")
    public Integer addAdmin(Admin admin);
}
