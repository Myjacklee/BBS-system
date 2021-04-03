package com.nuist.dao;

import com.nuist.domain.Friend;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendDao {
    @Select("select uid,nickname from user where uid=#{uid}")
    public List<Friend> findFriend(Friend friend);
    @Insert("insert into add_friend_request(sender_uid,receiver_uid) values(#{sender},#{receiver})")
    public Integer sendAddFriendRequest(@Param("sender") Integer senderUid, @Param("receiver") Integer receiverUid);
    @Select("select add_friend_request.sender_uid as uid,user.nickname from add_friend_request,user where add_friend_request.receiver_uid=#{uid} and add_friend_request.states=0 and user.uid=add_friend_request.sender_uid")
    public List<Friend> getMessage(Integer uid);
    @Update("update add_friend_request set states=#{states} where sender_uid=#{sender_uid} and receiver_uid=#{receiver_uid}")
    public Integer dealWithRequest(@Param("sender_uid") Integer sender_uid,@Param("receiver_uid") Integer receiver_uid,@Param("states") Integer states);
    @Insert("insert into relationship(user_A,user_B) values(#{A},#{B})")
    public Integer addFriend(@Param("A")Integer A,@Param("B")Integer B);
    @Select("select relationship.user_B as uid,user.nickname as nickname from relationship,user where relationship.user_A=#{uid} and user.uid=relationship.user_B  union select relationship.user_A as uid ,user.nickname as nickname from relationship,user where relationship.user_B=#{uid} and user.uid=relationship.user_A")
    public List<Friend> findAllFriends(Integer uid);
}
