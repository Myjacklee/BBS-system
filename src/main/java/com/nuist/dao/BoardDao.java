package com.nuist.dao;

import com.nuist.domain.Board;
import com.nuist.domain.Reply;
import org.apache.ibatis.annotations.*;
import org.aspectj.lang.annotation.DeclareError;

import java.sql.Time;
import java.util.List;

public interface BoardDao {
    @Select("select *,user.nickname as nickname from board,user where bbs_section_id=#{postId} and board.uid=user.uid order by last_reply_time desc")
    public List<Board> findAllBoard(Integer postId);
    @Insert("insert into board(bbs_section_id,uid,board_title,board_content,board_create_time,last_reply_time) values(#{bbs_section_id},#{uid},#{board_title},#{board_content},#{board_create_time},#{last_reply_time})")
    public Integer addBoard(Board board);
    @Select("select *,user.nickname as nickname,user.head_url as headURL from board,user where board_id=#{board_id} and board.uid=user.uid")
    public Board findBoardById(Integer board_id);
    @Update("update board set board_reply_num=board_reply_num+1 where board_id=#{boardId}")
    public Integer addReplyNum(Integer boardId);
    @Update("update board set last_reply_time=#{reply_time} where board_id=#{board_id}")
    public Integer updateLastReplyTime(Reply reply);
    @Select("select *,post.section_name as section_name from board,post where uid=#{uid} and board.bbs_section_id=post.bbs_section_id")
    public List<Board> findBoardByUid(Integer uid);
    //使用#{arg0}，{arg1}这样的形式,或者使用别名
    @Delete("delete from board where uid=#{uid} and board_id=#{boardId}")
    public Integer deleteBoardByBoardId(@Param("uid") Integer uid,@Param("boardId") Integer boardId);
    @Delete("delete from board where  board_id=#{boardId} and bbs_section_id=#{postId}")
    public Integer adminDeleteBoardByBoardId(@Param("boardId") Integer boardId,@Param("postId")Integer postId);
    @Select("select uid from board where board_id=#{boardId}")
    public Integer findUidByBoardId(Integer boardId);
    @Update("update board set board_reply_num=board_reply_num-1 where board_id=(select board_id from reply_board where reply_id = #{replyId} and uid=#{uid})")
    public Integer reduceReplyNumByReplyId(@Param("replyId") Integer replyId,@Param("uid") Integer uid);
}
