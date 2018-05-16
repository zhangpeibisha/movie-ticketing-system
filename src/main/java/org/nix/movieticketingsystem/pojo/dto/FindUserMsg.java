package org.nix.movieticketingsystem.pojo.dto;

import org.nix.movieticketingsystem.pojo.dto.base.AbstractBaseResultDto;
import org.nix.movieticketingsystem.pojo.entity.User;

/**
 * Create by zhangpe0312@qq.com on 2018/5/16.
 */
public class FindUserMsg extends AbstractBaseResultDto {

    private User user;

    public FindUserMsg(User user) {
        this.user = user;
    }

    @Override
    public void handler() {
        user.setPassword(null);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
