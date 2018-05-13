package org.nix.movieticketingsystem.commons.enums;

/**
 * Create by zhangpe0312@qq.com on 2018/5/13.
 */
public enum  SessionEnum {

    SESSION_USER("user","当前用户");

    private String key;
    private String msg;

    SessionEnum(String key, String msg) {
        this.key = key;
        this.msg = msg;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
