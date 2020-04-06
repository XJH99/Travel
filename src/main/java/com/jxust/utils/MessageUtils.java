package com.jxust.utils;

import java.util.Date;

/**
 * 统一接口返回的工具类
 */
public class MessageUtils {
    /**
     *  返回失败的消息，一般用于增删改操作的返回
     * @param msg
     * @return
     */
    public static Message error(String msg) {
        Message message = new Message();
        message.setStatus(500);
        message.setMessage(msg);
        message.setTimeStamp(new Date().getTime());
        return message;
    }

    /**
     *  返回成功的消息，一般用于增删改操作的返回
     * @param msg
     * @return
     */
    public static Message success(String msg) {
        Message message = new Message();
        message.setStatus(200);
        message.setMessage(msg);
        message.setTimeStamp(new Date().getTime());
        return message;
    }

    /**
     *  返回成功的消息，一般用于查询结果的返回
     * @param msg
     * @return
     */
    public static Message success(String msg, Object data) {
        Message message = new Message();
        message.setStatus(200);
        message.setMessage(msg);
        message.setData(data);
        message.setTimeStamp(new Date().getTime());
        return message;
    }

    /**
     * 返回成功的消息，一般用于查询操作的结果返回
     * */
    public static Message success(Object data){
        Message message = new Message();
        message.setStatus(200);
        message.setMessage("success");
        message.setData(data);
        message.setTimeStamp(new Date().getTime());
        return message;
    }
}
