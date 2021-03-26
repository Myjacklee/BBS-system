package com.nuist.exception;

/**
 * @author LiZonggen
 * @date 2021-03-21 14:21
 * @description:自定义异常类
 * @version:
 */
public class SysException extends Exception {
    private static final long serialVersionUID=4055945147128016300L;
    //异常提示信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public SysException(String message){
        this.message=message;
    }
}
