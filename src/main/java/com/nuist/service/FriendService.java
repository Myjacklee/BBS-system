package com.nuist.service;

import com.nuist.domain.Friend;
import com.nuist.domain.FriendAddRequest;

import java.util.List;

public interface FriendService {
    public List<Friend> findFriend(Friend friend);
    public Integer addFriend(Integer senderUid,Integer receiverUid);
    public List<FriendAddRequest> getMessage(Integer uid);
    public Integer dealWithRequest(FriendAddRequest friendAddRequest);
    public List<Friend> findAllFriends(Integer uid);
    public List<Friend> friendRecommend(Integer uid);
    public Integer  deleteFriendById(Integer friendId,Integer uid);
}
