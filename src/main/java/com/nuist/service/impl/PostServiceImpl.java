package com.nuist.service.impl;

import com.nuist.dao.BoardDao;
import com.nuist.dao.PostDao;
import com.nuist.domain.Board;
import com.nuist.domain.Post;
import com.nuist.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiZonggen
 * @date 2021-03-29 15:05
 * @description:主页服务层
 * @version:
 */
@Service("postService")
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;
    @Autowired
    private BoardDao boardDao;
    @Override
    public List<Post> findAllPost() {
        return postDao.findAllPost();
    }
    @Override
    public Integer addPost(Post post) {
        return postDao.addPost(post);
    }



    @Override
    public Post findPostById(Integer id) {
        return postDao.findPostById(id);
    }



}
