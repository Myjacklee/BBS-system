package com.nuist.domain;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * @author LiZonggen
 * @date 2021-04-01 14:38
 * @description:评论实体类
 * @version:
 */
public class Comment {
    private Integer user_comment_id;
    private Integer reply_id;
    private Integer uid;
    private String comment_nickname;
    private String user_comment_content;
    private Integer user_comment_target;
    private String comment_target_nickname;
    private Timestamp user_comment_time;

    public Integer getUser_comment_id() {
        return user_comment_id;
    }

    public void setUser_comment_id(Integer user_comment_id) {
        this.user_comment_id = user_comment_id;
    }

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getComment_nickname() {
        return comment_nickname;
    }

    public void setComment_nickname(String comment_nickname) {
        this.comment_nickname = comment_nickname;
    }

    public String getUser_comment_content() {
        return user_comment_content;
    }

    public void setUser_comment_content(String user_comment_content) {
        this.user_comment_content = user_comment_content;
    }

    public Integer getUser_comment_target() {
        return user_comment_target;
    }

    public void setUser_comment_target(Integer user_comment_target) {
        this.user_comment_target = user_comment_target;
    }

    public String getComment_target_nickname() {
        return comment_target_nickname;
    }

    public void setComment_target_nickname(String comment_target_nickname) {
        this.comment_target_nickname = comment_target_nickname;
    }

    public Timestamp getUser_comment_time() {
        return user_comment_time;
    }

    public void setUser_comment_time(Timestamp user_comment_time) {
        this.user_comment_time = user_comment_time;
    }
}
