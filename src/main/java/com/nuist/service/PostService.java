package com.nuist.service;

import com.nuist.domain.Board;
import com.nuist.domain.Post;

import java.util.List;

public interface PostService {
    public List<Post> findAllPost();
    public Integer addPost(Post post);
    public List<Board> findAllBoard(Integer postId);
    public Post findPostById(Integer id);
    public Integer addBoard(Board board,Integer bbs_section_id);
}
