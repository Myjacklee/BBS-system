package com.nuist.domain;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * @author LiZonggen
 * @date 2021-03-29 19:11
 * @description:主题帖实体类
 * @version:
 */
public class Board {
    private Integer board_id;
    private Integer bbs_section_id;
    private String uid;
    private String nickname;
    private String board_title;
    private String board_content;
    private Timestamp board_create_time;
    private Timestamp last_reply_time;

    public Integer getBoard_id() {
        return board_id;
    }

    public void setBoard_id(Integer board_id) {
        this.board_id = board_id;
    }

    public Integer getBbs_section_id() {
        return bbs_section_id;
    }

    public void setBbs_section_id(Integer bbs_section_id) {
        this.bbs_section_id = bbs_section_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    public String getBoard_content() {
        return board_content;
    }

    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }

    public Timestamp getBoard_create_time() {
        return board_create_time;
    }

    public void setBoard_create_time(Timestamp board_create_time) {
        this.board_create_time = board_create_time;
    }

    public Timestamp getLast_reply_time() {
        return last_reply_time;
    }

    public void setLast_reply_time(Timestamp last_reply_time) {
        this.last_reply_time = last_reply_time;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
