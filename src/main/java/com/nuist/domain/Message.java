package com.nuist.domain;

import java.sql.Timestamp;

/**
 * @author LiZonggen
 * @date 2021-04-05 14:52
 * @description:消息实体类
 * @version:
 */
public class Message {
    private Integer message_id;
    private Integer sender_uid;
    private String sender_name;
    private Integer target_uid;
    private String message_url;
    private String message_content;
    private Integer read_flag;
    private Timestamp message_time;

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public Integer getSender_uid() {
        return sender_uid;
    }

    public void setSender_uid(Integer sender_uid) {
        this.sender_uid = sender_uid;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public Integer getTarget_uid() {
        return target_uid;
    }

    public void setTarget_uid(Integer target_uid) {
        this.target_uid = target_uid;
    }

    public String getMessage_url() {
        return message_url;
    }

    public void setMessage_url(String message_url) {
        this.message_url = message_url;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public Integer getRead_flag() {
        return read_flag;
    }

    public void setRead_flag(Integer read_flag) {
        this.read_flag = read_flag;
    }

    public Timestamp getMessage_time() {
        return message_time;
    }

    public void setMessage_time(Timestamp message_time) {
        this.message_time = message_time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", sender_uid=" + sender_uid +
                ", sender_name='" + sender_name + '\'' +
                ", target_uid=" + target_uid +
                ", message_url='" + message_url + '\'' +
                ", message_content='" + message_content + '\'' +
                ", read_flag=" + read_flag +
                ", message_time=" + message_time +
                '}';
    }
}
