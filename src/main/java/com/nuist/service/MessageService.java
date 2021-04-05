package com.nuist.service;

import com.nuist.domain.Message;

import java.util.List;

public interface MessageService {
    public Integer addMessage(Message message);
    public List<Message> findNewMessageByReceiverUid(Integer receiverUid);
    public List<Message> findHistoryMessageByReceiverUid(Integer receiverUid);
    public Integer getMessageNumByUid(Integer uid);

}
