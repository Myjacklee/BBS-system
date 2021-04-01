package com.nuist.dao;

import com.nuist.domain.Reply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyDao {
    @Insert("insert into reply_board(board_id,uid,reply_content,reply_time,floor) values(#{board_id},#{uid},#{reply_content},#{reply_time},(select count(*)+1 from reply_board as r where r.board_id=#{board_id}))")
    @SelectKey(keyColumn = "reply_id" ,keyProperty = "reply_id",resultType = Integer.class,before = false,statement = "select last_insert_id()")
    public Integer addReply(Reply reply);
    @Select("select *,user.nickname from reply_board,user where board_id=#{board_id} and user.uid=reply_board.uid")
    public List<Reply> findAllReply(Integer board_id);
    @Select("select * from reply_board where reply_id=#{reply_id}")
    public Reply findReplyById(Integer reply_id);
    @Select("select * from reply_board where uid=#{uid}")
    public List<Reply> findReplyByUid(Integer uid);
    @Delete("delete from reply_board where board_id=#{boardId}")
    public Integer deleteReplyByBoardId(Integer boardId);
}
