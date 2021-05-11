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
    private String board_title;
    private Integer uid;
    private String nickname;
    private String headURL;
    private String reply_content;
    private Timestamp reply_time;
    private Integer floor;
    private Integer senderBoardNum;

    private Integer reply_target_floor;
    private String reply_target_content;

    public Integer getSenderBoardNum() {
        return senderBoardNum;
    }

    public void setSenderBoardNum(Integer senderBoardNum) {
        this.senderBoardNum = senderBoardNum;
    }

    public String getHeadURL() {
        return headURL;
    }

    public void setHeadURL(String headURL) {
        this.headURL = headURL;
    }

    public Integer getReply_target_floor() {
        return reply_target_floor;
    }

    public void setReply_target_floor(Integer reply_target_floor) {
        this.reply_target_floor = reply_target_floor;
    }

    public String getReply_target_content() {
        return reply_target_content;
    }

    public void setReply_target_content(String reply_target_content) {
        this.reply_target_content = reply_target_content;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }


    @Override
    public String toString() {
        return "Reply{" +
                "reply_id=" + reply_id +
                ", board_id=" + board_id +
                ", board_title='" + board_title + '\'' +
                ", uid=" + uid +
                ", nickname='" + nickname + '\'' +
                ", headURL='" + headURL + '\'' +
                ", reply_content='" + reply_content + '\'' +
                ", reply_time=" + reply_time +
                ", floor=" + floor +
                ", senderBoardNum=" + senderBoardNum +
                ", reply_target_floor=" + reply_target_floor +
                ", reply_target_content='" + reply_target_content + '\'' +
                '}';
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
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
