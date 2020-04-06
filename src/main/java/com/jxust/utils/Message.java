package com.jxust.utils;

/**
 * 统一返回接口的message类
 */
public class Message {
    //状态码
    private Integer status;
    //信息
    private String message;
    //数据
    private Object data;
    //时间戳
    private Long  timeStamp;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
