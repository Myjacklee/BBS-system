package com.nuist.service.impl;

import com.nuist.dao.BoardDao;
import com.nuist.dao.MessageDao;
import com.nuist.dao.ReplyDao;
import com.nuist.domain.Message;
import com.nuist.domain.Reply;
import com.nuist.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiZonggen
 * @date 2021-03-31 10:23
 * @description:回复功能业务层
 * @version:
 */
@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyDao replyDao;
    @Autowired
    private BoardDao boardDao;
    @Autowired
    private MessageDao messageDao;
    @Override
    public Integer addReply(Reply reply) {
        replyDao.addReply(reply);
        boardDao.addReplyNum(reply.getBoard_id());
        boardDao.updateLastReplyTime(reply);
        //查询楼层
        reply.setFloor(replyDao.findReplyById(reply.getReply_id()).getFloor());
        Message message=new Message();
        message.setMessage_url("/board/"+reply.getBoard_id()+"/#"+reply.getFloor());
        if(reply.getReply_content().length()<=20){
            message.setMessage_content(reply.getReply_content());
        }else{
            message.setMessage_content(reply.getReply_content().substring(0,20)+"...");
        }
        message.setSender_uid(reply.getUid());
        Integer targetUid=boardDao.findUidByBoardId(reply.getBoard_id());
        message.setTarget_uid(targetUid);
        message.setMessage_time(reply.getReply_time());
        messageDao.addMessage(message);
        return 1;
    }

    @Override
    public List<Reply> findAllReply(Integer board_id) {
        return replyDao.findAllReply(board_id);
    }

    @Override
    public Reply findReplyById(Integer reply_id) {
        return replyDao.findReplyById(reply_id);
    }

    @Override
    public List<Reply> findReplyByUid(Integer uid) {
        return replyDao.findReplyByUid(uid);
    }
}
