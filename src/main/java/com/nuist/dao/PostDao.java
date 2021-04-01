package com.nuist.dao;

import com.nuist.domain.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
* @Author: LiZonggen
* @Date: 2021/4/1
* @Description: 用户的帖子持久层接口
*/
@Repository
public interface PostDao {
    @Select("select * from post")
    public List<Post> findAllPost();
    @Insert("insert into post(section_name,post_describe) values(#{section_name},#{post_describe})")
    @SelectKey(keyColumn = "bbs_section_id",keyProperty = "bbs_section_id",resultType = Integer.class,before = false,statement = "select last_insert_id()")
    public Integer addPost(Post post);
    @Select("select * from post where bbs_section_id=#{id}")
    public Post findPostById(Integer id);
    @Update("update post set post_num=post_num+1 where bbs_section_id=#{bbs_section_id}")
    public Integer addPostNum(Integer bbs_section_num);
}
