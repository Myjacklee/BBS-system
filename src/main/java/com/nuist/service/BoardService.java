package com.nuist.service;

import com.nuist.domain.Board;

import java.util.List;

public interface BoardService {
    public List<Board> findAllBoard(Integer postId);
    public Integer addBoard(Board board,Integer bbs_section_id);
    public Board findBoardById(Integer board_id);
    public List<Board> findBoardByUid(Integer uid);
    public Integer deleteBoardByBoardId(Integer uid,Integer boardId);
    public String adminDeleteBoard(Integer postId,Integer boardId,Integer uid);
}
