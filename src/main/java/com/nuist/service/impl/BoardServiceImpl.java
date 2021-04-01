package com.nuist.service.impl;

import com.nuist.dao.BoardDao;
import com.nuist.dao.PostDao;
import com.nuist.dao.ReplyDao;
import com.nuist.domain.Board;
import com.nuist.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiZonggen
 * @date 2021-03-30 20:39
 * @description:版块服务层
 * @version:
 */
@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDao boardDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private ReplyDao replyDao;
    @Override
    public List<Board> findAllBoard(Integer postId) {
        return boardDao.findAllBoard(postId);
    }
    @Override
    public Integer addBoard(Board board,Integer bbs_section_id) {
        if(boardDao.addBoard(board)==1&&postDao.addPostNum(bbs_section_id)==1){
            return 1;
        }else{
            return 0;
        }
    }
    @Override
    public Board findBoardById(Integer board_id) {
        return boardDao.findBoardById(board_id);
    }

    @Override
    public List<Board> findBoardByUid(Integer uid) {
        return boardDao.findBoardByUid(uid);
    }

    @Override
    public Integer deleteBoardByBoardId(Integer uid, Integer boardId) {
        replyDao.deleteReplyByBoardId(boardId);
        if(boardDao.deleteBoardByBoardId(uid,boardId)==1){
            return 1;
        }else{
            return 0;
        }
    }


}
