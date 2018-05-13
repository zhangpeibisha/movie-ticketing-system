package org.nix.movieticketingsystem.commons.utils;

import org.nix.movieticketingsystem.pojo.dto.base.BaseResultDto;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by zhangpe0312@qq.com on 2018/5/13.
 */
public class ResultMvcMap {

    private Map<String,Object> result = new HashMap<>();

    public ResultMvcMap success(){
        result.put("code",HttpStatus.OK.value());
        return this;
    }

    public ResultMvcMap success(BaseResultDto data){
        success();
        result.put("data",data);
        return this;
    }

    public ResultMvcMap fail(HttpStatus status,String msg){
        result.put("code",status.value());
        result.put("msg",msg);
        return this;
    }

    /**
     * 系统异常 状态码 500
     * @param msg 异常信息
     * @return
     */
    public ResultMvcMap fail(String msg){
        result.put("code",HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.put("msg",msg);
        return this;
    }

    public Map<String,Object> send(){
        return result;
    }
}
