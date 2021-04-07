package com.nuist.dao;

import com.nuist.domain.Friend;
import com.nuist.domain.FriendAddRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface FriendDao {
    @Select("select uid,nickname from user where uid=#{uid}")
    public List<Friend> findFriend(Friend friend);
    @Select("select uid,nickname from user where uid=#{uid}")
    public Friend findFriendByUid(Integer uid);
    @Insert("insert into add_friend_request(sender_uid,receiver_uid,md5_code) values(#{sender},#{receiver},#{md5_code})")
    public Integer sendAddFriendRequest(@Param("sender") Integer senderUid, @Param("receiver") Integer receiverUid,@Param("md5_code") String md5_code);
    @Select("select add_friend_request.sender_uid as uid,user.nickname,add_friend_request.request_id as request_id,add_friend_request.md5_code as md5_code from add_friend_request,user where add_friend_request.receiver_uid=#{uid} and add_friend_request.states=0 and user.uid=add_friend_request.sender_uid")
    public List<FriendAddRequest> getMessage(Integer uid);
    @Update("update add_friend_request set states=#{states} where request_id=#{request_id} and md5_code=#{md5_code}")
    @SelectKey(keyColumn = "sender_uid",keyProperty = "uid",before = false,statement = "select sender_uid from add_friend_request where request_id=#{request_id}",resultType = Integer.class)
    public Integer dealWithRequest(FriendAddRequest friendAddRequest);
    @Insert("insert into relationship(user_A,user_B) values(#{A},#{B})")
    public Integer addFriend(@Param("A")Integer A,@Param("B")Integer B);
    @Select("select relationship.user_B as uid,user.nickname as nickname from relationship,user where relationship.user_A=#{uid} and user.uid=relationship.user_B  union select relationship.user_A as uid ,user.nickname as nickname from relationship,user where relationship.user_B=#{uid} and user.uid=relationship.user_A")
    public List<Friend> findAllFriends(Integer uid);
    @Select("select relationship.user_B as uid from relationship where relationship.user_A=#{uid}   union select relationship.user_A as uid  from relationship where relationship.user_B=#{uid} ")
    public ArrayList<Integer> findAllFriendUid(Integer uid);
}
