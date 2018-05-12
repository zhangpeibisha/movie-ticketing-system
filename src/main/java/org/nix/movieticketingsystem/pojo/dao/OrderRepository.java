package org.nix.movieticketingsystem.pojo.dao;

import org.nix.movieticketingsystem.pojo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by zhangpe0312@qq.com on 2018/5/12.
 */
public interface OrderRepository extends JpaRepository<Order,Integer> {

}
