package org.nix.movieticketingsystem.pojo.dto.base;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 */
public abstract class AbstractBaseResultDto implements BaseResultDto{

    @Override
    public BaseResultDto result() {
        handler();
        return this;
    }
}
