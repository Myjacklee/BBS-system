package com.nuist.dao;

import com.nuist.domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardDao {
    @Select("select *,user.nickname as nickname from board,user where bbs_section_id=#{postId} and board.uid=user.uid order by last_reply_time desc")
    public List<Board> findAllBoard(Integer postId);
    @Insert("insert into board(bbs_section_id,uid,board_title,board_content,board_create_time,last_reply_time) values(#{bbs_section_id},#{uid},#{board_title},#{board_content},#{board_create_time},#{last_reply_time})")
    public Integer addBoard(Board board);
    @Select("select *,user.nickname as nickname from board,user where board_id=#{board_id} and board.uid=user.uid")
    public Board findBoardById(Integer board_id);
}
