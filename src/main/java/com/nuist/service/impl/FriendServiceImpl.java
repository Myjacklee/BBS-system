package com.nuist.service.impl;

import com.nuist.dao.FriendDao;
import com.nuist.domain.Friend;
import com.nuist.service.FriendService;
import com.nuist.websocket.MessageWebSocket;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiZonggen
 * @date 2021-04-02 10:35
 * @description:朋友业务层
 * @version:
 */
@Service("friendService")
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendDao friendDao;

    @Override
    public List<Friend> findFriend(Friend friend) {
        return friendDao.findFriend(friend);
    }

    @Override
    public Integer addFriend(Integer senderUid, Integer receiverUid) {
        List<Friend> allFriends=friendDao.findAllFriends(senderUid);
        for(int i=0;i<allFriends.size();i++){
            if(allFriends.get(i).getUid().equals(receiverUid)){
//                若已经添加了好友则返回2
                return 2;
            }
        }
        return friendDao.sendAddFriendRequest(senderUid,receiverUid);
    }

    @Override
    public List<Friend> getMessage(Integer uid) {
        return friendDao.getMessage(uid);
    }

    @Override
    public Integer dealWithRequest(Integer sender_uid, Integer receiver_uid, Integer states) {
        if(states==1&&friendDao.dealWithRequest(sender_uid,receiver_uid,states)==1){
            friendDao.addFriend(sender_uid, receiver_uid);
            return 1;
        }else if(states==2){
            friendDao.dealWithRequest(sender_uid,receiver_uid,states);
            return 0;
        }else{
            return 0;
        }

    }

    @Override
    public List<Friend> findAllFriends(Integer uid) {
        return friendDao.findAllFriends(uid);
    }
}
