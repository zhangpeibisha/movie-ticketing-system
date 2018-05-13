package org.nix.movieticketingsystem.web.handler.exception;

import org.apache.log4j.Logger;
import org.nix.movieticketingsystem.commons.exceptions.AuthorityException;
import org.nix.movieticketingsystem.commons.utils.ResultMvcMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

/**
 * Create by zhangpe0312@qq.com on 2018/5/13.
 */
@ControllerAdvice
@ResponseBody
public class HandlerWebException {

    private Logger logger = Logger.getLogger(HandlerWebException.class);

    /**
     * 用户没权限将出发此异常,返回状态码 403
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AuthorityException.class)
    public Map<String,Object> authorityException(AuthorityException e){
        e.printStackTrace();
        logger.info(e);
        return new ResultMvcMap()
                .fail(HttpStatus.FORBIDDEN,"用户权限不足")
                .send();
    }

}
