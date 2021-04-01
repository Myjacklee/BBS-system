package com.nuist.domain;

/**
 * @author LiZonggen
 * @date 2021-04-01 13:29
 * @description:回复结果实体类
 * @version:
 */
public class ReplyResult {
    private String message;
    private Integer floor;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
