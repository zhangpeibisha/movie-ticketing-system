package org.nix.movieticketingsystem.pojo.dto;

import org.nix.movieticketingsystem.pojo.dto.base.AbstractBaseResultDto;
import org.nix.movieticketingsystem.pojo.entity.Order;


/**
 * Create by zhangpe0312@qq.com on 2018/5/15.
 */
public class FindOrderDto extends AbstractBaseResultDto {

    private Order order;

    public FindOrderDto(Order order) {
        this.order = order;
    }

    @Override
    public void handler() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
