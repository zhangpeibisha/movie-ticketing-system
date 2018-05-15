package org.nix.movieticketingsystem.pojo.dao;

import org.nix.movieticketingsystem.pojo.entity.ToBeReleased;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/12.
 */
@Transactional
public interface ToBeReleasedRepository extends JpaRepository<ToBeReleased,Integer> {
    /**
     * 根据电影和电影院和距离今天的天数查询能够播放的电影
     * @param movieId 电影id
     * @param cinemaId 影院id
     * @param day 距离天数
     * @return 待放映的电影
     */
    @Query(nativeQuery = true,
            value = " \n" +
                    "SELECT * FROM to_be_released WHERE to_be_released.movie = ?1 AND to_be_released.hall IN(\n" +
                    "      SELECT hall.id FROM hall WHERE hall.cinema = ?2\n" +
                    ") AND datediff(to_be_released.play_time,NOW()) = ?3")
    List<ToBeReleased> findReleasedByPlayTimeAndCinema(int movieId, int cinemaId, int day);

    @Query(nativeQuery = true,
    value = "SELECT * FROM to_be_released WHERE id = ?1")
    ToBeReleased findById(int tobeId);
}
