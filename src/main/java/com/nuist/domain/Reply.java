package com.nuist.domain;

import java.sql.Timestamp;

/**
 * @author LiZonggen
 * @date 2021-03-30 14:55
 * @description:主题帖回帖内容实体类
 * @version:
 */
public class Reply {
    private Integer reply_id;
    private Integer board_id;
    private String uid;
    private String nickname;
    private String reply_content;
    private Timestamp reply_time;

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }

    public Integer getBoard_id() {
        return board_id;
    }

    public void setBoard_id(Integer board_id) {
        this.board_id = board_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public Timestamp getReply_time() {
        return reply_time;
    }

    public void setReply_time(Timestamp reply_time) {
        this.reply_time = reply_time;
    }
}
