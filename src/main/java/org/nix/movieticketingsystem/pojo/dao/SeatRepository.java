package org.nix.movieticketingsystem.pojo.dao;

import org.nix.movieticketingsystem.pojo.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by zhangpe0312@qq.com on 2018/5/12.
 */
public interface SeatRepository extends JpaRepository<Seat,Integer> {

}
