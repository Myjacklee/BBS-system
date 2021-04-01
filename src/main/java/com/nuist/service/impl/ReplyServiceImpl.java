package com.nuist.service.impl;

import com.nuist.dao.BoardDao;
import com.nuist.dao.ReplyDao;
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
    @Override
    public Integer addReply(Reply reply) {
        replyDao.addReply(reply);
        boardDao.addReplyNum(reply.getBoard_id());
        boardDao.updateLastReplyTime(reply);
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
