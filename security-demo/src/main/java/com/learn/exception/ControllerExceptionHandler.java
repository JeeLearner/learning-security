package com.learn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //服务器内部错误500
    public Map<String, Object> handleUserNotExistException(UserNotExistException ex){
        Map<String, Object> result = new HashMap<String,Object>();
        result.put("id", ex.getId());
        result.put("message", ex.getMessage());
        return result;
    }
}
