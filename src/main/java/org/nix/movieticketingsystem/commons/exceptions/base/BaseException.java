package org.nix.movieticketingsystem.commons.exceptions.base;

import org.springframework.http.HttpStatus;

/**
 * Create by zhangpe0312@qq.com on 2018/5/13.
 */
public class BaseException extends RuntimeException{

    private HttpStatus status;
    private String msg;

    public BaseException(HttpStatus status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
