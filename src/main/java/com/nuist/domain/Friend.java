package com.nuist.domain;

/**
 * @author LiZonggen
 * @date 2021-04-02 10:19
 * @description:好友实体类
 * @version:
 */
public class Friend {
    private Integer uid;
    private String nickname;

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

    @Override
    public String toString() {
        return "Friend{" +
                "uid=" + uid +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
