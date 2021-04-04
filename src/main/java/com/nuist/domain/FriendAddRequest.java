package com.nuist.domain;

/**
 * @author LiZonggen
 * @date 2021-04-03 10:39
 * @description:添加好友请求实体类
 * @version:
 */
public class FriendAddRequest {
    private Integer uid;
    private String nickname;
    private String md5_code;
    private Integer request_id;
    private Integer states;
    private Integer receiver_uid;

    public Integer getReceiver_uid() {
        return receiver_uid;
    }

    public void setReceiver_uid(Integer receiver_uid) {
        this.receiver_uid = receiver_uid;
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
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

    public String getMd5_code() {
        return md5_code;
    }

    public void setMd5_code(String md5_code) {
        this.md5_code = md5_code;
    }

    public Integer getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Integer request_id) {
        this.request_id = request_id;
    }

    @Override
    public String toString() {
        return "FriendAddRequest{" +
                "uid=" + uid +
                ", nickname='" + nickname + '\'' +
                ", md5_code='" + md5_code + '\'' +
                ", request_id=" + request_id +
                ", states=" + states +
                ", receiver_uid=" + receiver_uid +
                '}';
    }
}
