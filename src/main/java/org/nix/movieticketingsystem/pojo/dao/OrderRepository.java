package org.nix.movieticketingsystem.pojo.dao;

import org.nix.movieticketingsystem.pojo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/12.
 */
public interface OrderRepository extends JpaRepository<Order,Integer> {
    /**
     *  根据用户id查询用户订单
     * @param userId 用户id
     * @return 用户订单
     */
    @Query(nativeQuery = true,
    value = "SELECT * FROM user_order " +
            "WHERE user_order.`user` = ?1")
    List<Order> findAllByUser(int userId);

}
