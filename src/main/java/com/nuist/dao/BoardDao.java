package com.nuist.dao;

import com.nuist.domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardDao {
    @Select("select * from board where bbs_section_id=#{postId}")
    public List<Board> findAllBoard(Integer postId);
    @Insert("insert into board(bbs_section_id,uid,board_title,board_content,board_create_time,last_reply_time) values(#{bbs_section_id},#{uid},#{board_title},#{board_content},#{board_create_time},#{last_reply_time})")
    public Integer addBoard(Board board);
}
