package com.nuist.service.impl;

import com.nuist.dao.FriendDao;
import com.nuist.domain.Friend;
import com.nuist.domain.FriendAddRequest;
import com.nuist.service.FriendService;
import com.nuist.utils.MD5Util;
import com.nuist.websocket.MessageWebSocket;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
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
        Timestamp timestamp=new Timestamp(new Date().getTime());
        String md5_code= MD5Util.getMD5(timestamp+senderUid.toString()+receiverUid.toString());
        return friendDao.sendAddFriendRequest(senderUid,receiverUid,md5_code);
    }

    @Override
    public List<FriendAddRequest> getMessage(Integer uid) {
        return friendDao.getMessage(uid);
    }

    @Override
    public Integer dealWithRequest(FriendAddRequest friendAddRequest) {
        if(friendAddRequest.getStates()==1&&friendDao.dealWithRequest(friendAddRequest)==1){
            friendDao.addFriend(friendAddRequest.getUid(), friendAddRequest.getReceiver_uid());
            return 1;
        }else if(friendAddRequest.getStates()==2){
            friendDao.dealWithRequest(friendAddRequest);
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
