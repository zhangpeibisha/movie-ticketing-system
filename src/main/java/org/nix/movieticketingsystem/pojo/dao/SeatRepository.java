package org.nix.movieticketingsystem.pojo.dao;

import org.nix.movieticketingsystem.pojo.entity.Seat;
import org.nix.movieticketingsystem.pojo.entity.ToBeReleased;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/12.
 */
@Transactional
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    /**
     * 通过待放映电影查询到该电影播放时已经购买了的位子
     *
     * @return 这个影厅放映待放映电影时已经被购买的座位
     */
    @Query(nativeQuery = true,
            value = "SELECT * FROM seat WHERE seat.id IN(\n" +
                    "  SELECT buy_seat.seat FROM buy_seat WHERE buy_seat.to_be_released = ?1\n" +
                    ")")
    List<Seat> findBuySeatByToBeReleasedId(int toBeReleasedId);

    @Query(nativeQuery = true,
            value = "SELECT * FROM seat WHERE seat.hall = ?1")
    List<Seat> findAllSeatByHallToBeReleasedId(int toBeReleasedId);

}
