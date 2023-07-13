package com.example.springbootdemo.config;

import cn.dev33.satoken.exception.NotLoginException;
import cn.hutool.json.JSONObject;
import com.example.springbootdemo.exception.HuiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        JSONObject json = new JSONObject();
        //处理后端验证失败产生的异常
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            json.set("error", exception.getBindingResult().getFieldError().getDefaultMessage());
        }
        //处理业务异常
        else if (e instanceof HuiException) {
            log.error("执行异常", e);
            HuiException exception = (HuiException) e;
            json.set("error", exception.getMsg());
        }
        //处理其余的异常
        else {
            log.error("执行异常", e);
            json.set("error", "系统异常，请联系管理员！");
        }
        return json.toString();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NotLoginException.class)
    public String unLoginHandler(Exception e) {
        JSONObject json = new JSONObject();
        json.set("error", e.getMessage());
        return json.toString();
    }

}