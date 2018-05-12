package org.nix.movieticketingsystem.pojo.dao;

import org.nix.movieticketingsystem.pojo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/12.
 */
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

    /**
     * 通过电影名字查询最近能够放映的电影院,进行分页展示
     *
     * @param movieName 电影名字
     * @param curr      当前页
     * @param limit     每页多少行数据
     * @return 最近三天能够放映该电影电影院，指定页的数据
     */
//    @Query(nativeQuery = true, value = "")
//    List<Cinema> findAllByMovieName(String movieName, int curr, int limit);

    /**
     * 通过电影名字查询最近能够放映的电影院总数
     * @param movieName 电影名字
     * @return 最近三天能够放映的电影院总数
     */
//    @Query(nativeQuery = true, value = "")
//    long CountByMovieName(String movieName);
}
