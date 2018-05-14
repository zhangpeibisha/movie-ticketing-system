package org.nix.movieticketingsystem.pojo.dao;

import org.nix.movieticketingsystem.pojo.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/12.
 */
@Transactional
public interface HallRepository extends JpaRepository<Hall, Integer> {

    /**
     * 通过电影id和电影院得到这个电影院能够播放的影厅
     * <p>
     * 1.查找到这个电影院
     * 2.查找到能够播放这个电影的影厅
     * @param cinemaId 电影院id
     * @param movieId 电影id
     * @return 该电影院能够播放的影厅
     */
    @Query(nativeQuery = true,
    value = "SELECT * FROM to_be_released WHERE movie = ?2 AND hall = (\n" +
            "  SELECT hall.id FROM hall WHERE hall.cinema = ?1\n" +
            ")")
    List<Hall> findHallByCinemaAndMovie(int cinemaId, int movieId);


}
