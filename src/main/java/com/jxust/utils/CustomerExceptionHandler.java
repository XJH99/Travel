package com.jxust.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一接口异常的处理
 */
@RestControllerAdvice
public class CustomerExceptionHandler {
    @ExceptionHandler(value =  Exception.class) // 捕获 Controller 中抛出的指定类型的异常，也可以指定其他异常
    public <E> Message handler(Exception exception) {
        exception.printStackTrace();
        if(exception instanceof CustomerException){
            return MessageUtils.error(exception.getMessage());
        }
        return MessageUtils.error("后台接口异常");
    }
}
