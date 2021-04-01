package com.nuist.service;

import com.nuist.domain.Reply;

import java.util.List;

public interface ReplyService {
    public Integer addReply(Reply reply);
    public List<Reply> findAllReply(Integer board_id);
    public Reply findReplyById(Integer reply_id);
    public List<Reply> findReplyByUid(Integer uid);
}
