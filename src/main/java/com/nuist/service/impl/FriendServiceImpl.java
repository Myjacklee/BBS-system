package com.nuist.service.impl;

import com.nuist.dao.FriendDao;
import com.nuist.dao.MessageDao;
import com.nuist.dao.UserDao;
import com.nuist.domain.Friend;
import com.nuist.domain.FriendAddRequest;
import com.nuist.domain.Message;
import com.nuist.service.FriendService;
import com.nuist.utils.FriendRecommend;
import com.nuist.utils.MD5Util;
import com.nuist.websocket.MessageWebSocket;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

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
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private UserDao userDao;
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
        Message message=new Message();
        message.setMessage_url("/friend/goFriend");
        message.setMessage_content("请求添加为好友");
        message.setSender_uid(senderUid);
        message.setTarget_uid(receiverUid);
        message.setMessage_time(timestamp);
        messageDao.addMessage(message);
        return friendDao.sendAddFriendRequest(senderUid,receiverUid,md5_code);
    }

    @Override
    public List<FriendAddRequest> getMessage(Integer uid) {
        return friendDao.getMessage(uid);
    }

    @Override
    public Integer dealWithRequest(FriendAddRequest friendAddRequest) {
        Message message=new Message();

        if(friendAddRequest.getStates()==1&&friendDao.dealWithRequest(friendAddRequest)==1){
            friendDao.addFriend(friendAddRequest.getUid(), friendAddRequest.getReceiver_uid());
            message.setMessage_url("/friend/goFriend");
            message.setMessage_content("接收了您的好友请求");
            message.setSender_uid(friendAddRequest.getReceiver_uid());
            message.setTarget_uid(friendAddRequest.getUid());
            messageDao.addMessage(message);
            return 1;
        }else if(friendAddRequest.getStates()==2){
            friendDao.dealWithRequest(friendAddRequest);
            message.setMessage_url("/friend/goFriend");
            message.setMessage_content("拒绝了您的好友请求");
            message.setSender_uid(friendAddRequest.getReceiver_uid());
            message.setTarget_uid(friendAddRequest.getUid());
            messageDao.addMessage(message);
            return 0;
        }else{
            return 0;
        }

    }

    @Override
    public List<Friend> findAllFriends(Integer uid) {
        return friendDao.findAllFriends(uid);
    }

    @Override
    public List<Friend> friendRecommend(Integer uid) {
        List<Integer> allUserUid=userDao.findAllUserUid();
        Map<Integer,ArrayList<Integer>> allUserFriend=new HashMap<>();
        for(Integer userUid:allUserUid){
            ArrayList<Integer> list=friendDao.findAllFriendUid(userUid);
            allUserFriend.put(userUid,list);
        }
        FriendRecommend.showAll(allUserFriend);
        List<Integer> list=FriendRecommend.commonNeighbors(allUserFriend,uid);

        for(Integer a:list){
            System.out.println(a);
        }
        List<Friend> recommendList=new ArrayList<>();
        for(Integer a:list){
            recommendList.add(friendDao.findFriendByUid(a));
        }
        for(Friend a:recommendList){
            System.out.println(a);
        }
        return recommendList;
    }


}
