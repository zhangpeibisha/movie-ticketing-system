package org.nix.movieticketingsystem.commons.exceptions;

import org.nix.movieticketingsystem.commons.exceptions.base.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Create by zhangpe0312@qq.com on 2018/5/13.
 */
public class AuthorityException extends BaseException {

    public AuthorityException() {
        super(HttpStatus.FORBIDDEN, "当前用户权限不足，拒绝访问");
    }
}
