package com.nuist.dao;

import com.nuist.domain.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LiZonggen
 * @date 2021-04-05 15:19
 * @description:消息持久层
 * @version:
 */
@Repository
public interface MessageDao {
    @Insert("insert into message_remind(message_url,message_content,sender_uid,target_uid,message_time) values(#{message_url},#{message_content},#{sender_uid},#{target_uid},#{message_time})")
    public Integer addMessage(Message message);
    @Select("select *,user.nickname as sender_name from message_remind,user where target_uid=#{receiverUid} and read_flag=0 and user.uid=message_remind.sender_uid order by message_time desc")
    public List<Message> findNewMessageByReceiverUid(Integer receiverUid);
    @Select("select *,user.nickname as sender_name from message_remind,user where target_uid=#{receiverUid} and read_flag=1 and user.uid=message_remind.sender_uid order by message_time desc")
    public List<Message> findHistoryMessageByReceiverUid(Integer receiverUid);
    @Update("update message_remind set read_flag=1 where target_uid=#{receiverUid} and read_flag=0")
    public Integer readAllMessage(Integer receiverUid);
    @Select("select count(*) from message_remind where target_uid=#{uid} and read_flag=0")
    public Integer getMessageNum(Integer uid);
}
