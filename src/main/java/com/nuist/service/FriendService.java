package com.nuist.service;

import com.nuist.domain.Friend;

import java.util.List;

public interface FriendService {
    public List<Friend> findFriend(Friend friend);
    public Integer addFriend(Integer senderUid,Integer receiverUid);
    public List<Friend> getMessage(Integer uid);
    public Integer dealWithRequest( Integer sender_uid, Integer receiver_uid,Integer states);
    public List<Friend> findAllFriends(Integer uid);
}
