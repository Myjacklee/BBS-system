package com.nuist.dao;

import com.nuist.domain.Reply;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyDao {
    @Insert("insert into reply_board(reply_target_floor,board_id,uid,reply_content,reply_time,floor) values(#{reply_target_floor},#{board_id},#{uid},#{reply_content},#{reply_time},(select count(*)+1 from reply_board as r where r.board_id=#{board_id}))")
    @SelectKey(keyColumn = "reply_id", keyProperty = "reply_id", resultType = Integer.class, before = false, statement = "select last_insert_id()")
    public Integer addReply(Reply reply);

//    @Select("select *,user.nickname as nickname,b.reply_content as reply_target_content  from reply_board as a,reply_board as b,user where a.board_id=#{board_id} and user.uid=a.uid and a.reply_target_floor=b.floor and b.board_id=#{board_id}")
    @Select("select c.nickname as nickname,d.* from user as c, " +
            "(select a.reply_id as reply_id,a.board_id as board_id,a.uid as uid,a.floor as floor,a.reply_content as reply_content,a.reply_time as reply_time,a.reply_target_floor as reply_target_floor,b.reply_content as reply_target_content from " +
            "(select * from reply_board where board_id=#{board_id}) as a left join reply_board as b on  a.reply_target_floor=b.floor and b.board_id=#{board_id}) as d" +
            " where c.uid=d.uid")
//    @Select("select a.reply_id as reply_id,a.board_id as board_id,a.uid as uid,a.floor as floor,a.reply_content as reply_content,a.reply_time as reply_time,a.reply_target_floor as reply_target_floor,b.reply_content as reply_target_content from " +
//            "(select * from reply_board where board_id=#{board_id}) as a left join reply_board as b on  a.reply_target_floor=b.floor and b.board_id=#{board_id}")
    public List<Reply> findAllReply(Integer board_id);

    @Select("select * from reply_board where reply_id=#{reply_id}")
    public Reply findReplyById(Integer reply_id);

    @Select("select *,board.board_title as board_title from reply_board,board where reply_board.uid=#{uid} and board.board_id=reply_board.board_id")
    public List<Reply> findReplyByUid(Integer uid);

    @Delete("delete from reply_board where board_id=#{boardId}")
    public Integer deleteReplyByBoardId(Integer boardId);

    @Delete("delete from reply_board where reply_id=#{reply_id} and uid=#{uid}")
    public Integer deleteReplyByReplyId(@Param("reply_id") Integer reply_id,@Param("uid") Integer uid);

}