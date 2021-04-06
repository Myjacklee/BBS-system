package com.nuist.domain;

/**
 * @author LiZonggen
 * @date 2021-04-06 11:30
 * @description:操作处理结果实体类
 * @version:
 */
public class OperateResult {
    private String title;
    private String message;
    private String state;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
