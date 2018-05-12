package org.nix.movieticketingsystem.pojo.dao;

import org.nix.movieticketingsystem.pojo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/12.
 */
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    /**
     * 查询热度最高的几个电影的信息
     * @param number 查询排名前 number 的电影
     * @return 指定数量的热度最高的几个电影信息
     */
    @Query(nativeQuery = true,value = "SELECT * FROM movie ORDER BY movie.hot LIMIT 0,?1")
    List<Movie> finHotMovieList(int number);

}
