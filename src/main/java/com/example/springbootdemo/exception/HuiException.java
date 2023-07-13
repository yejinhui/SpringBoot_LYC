package com.example.springbootdemo.exception;

import lombok.Data;

@Data
public class HuiException extends RuntimeException {
    private String msg;
    private int code = 500;

    public HuiException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public HuiException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public HuiException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public HuiException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

}
