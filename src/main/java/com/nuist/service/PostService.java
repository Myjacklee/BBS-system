package com.nuist.service;

import com.nuist.domain.Board;
import com.nuist.domain.Post;

import java.util.List;

public interface PostService {
    public List<Post> findAllPost();
    public Integer addPost(Post post);
    public Post findPostById(Integer id);

}
