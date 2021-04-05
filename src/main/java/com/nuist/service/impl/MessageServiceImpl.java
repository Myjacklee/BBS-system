package com.nuist.service.impl;

import com.nuist.dao.MessageDao;
import com.nuist.domain.Message;
import com.nuist.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiZonggen
 * @date 2021-04-05 15:32
 * @description:消息业务层
 * @version:
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;
    @Override
    public Integer addMessage(Message message) {
        return messageDao.addMessage(message);
    }

    @Override
    public List<Message> findNewMessageByReceiverUid(Integer receiverUid) {
        List<Message> newMessage= messageDao.findNewMessageByReceiverUid(receiverUid);
        messageDao.readAllMessage(receiverUid);
        return newMessage;
    }

    @Override
    public List<Message> findHistoryMessageByReceiverUid(Integer receiverUid) {
        return messageDao.findHistoryMessageByReceiverUid(receiverUid);
    }

    @Override
    public Integer getMessageNumByUid(Integer uid) {
        return messageDao.getMessageNum(uid);
    }
}
