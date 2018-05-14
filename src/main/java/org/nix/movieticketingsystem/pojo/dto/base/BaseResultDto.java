package org.nix.movieticketingsystem.pojo.dto.base;

/**
 * Create by zhangpe0312@qq.com on 2018/5/13.
 */
public interface BaseResultDto {

    /**
     * 返回处理数据结构
     * @return
     */
    BaseResultDto result();

    /**
     * 对一些数据进行处理
     */
    void handler();
}
