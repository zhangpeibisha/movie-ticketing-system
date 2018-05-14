package org.nix.movieticketingsystem.pojo.dao;

import org.nix.movieticketingsystem.pojo.entity.Cinema;
import org.nix.movieticketingsystem.pojo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Create by zhangpe0312@qq.com on 2018/5/12.
 */
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {


    /**
     * 通过电影名字查询最近能够放映的电影院总数
     * @param movieId 电影名字
     * @return 最近三天能够放映的电影院总数
     */
    @Query(nativeQuery = true, value =
            "SELECT\n" +
            "\tcount(*)\n" +
            "FROM\n" +
            "\tcinema\n" +
            "WHERE\n" +
            "\tid = (\n" +
            "\t\t--                从电影-影院中查找到电影\n" +
            "\t\tSELECT\n" +
            "\t\t\tmovie_cinema.cinemas\n" +
            "\t\tFROM\n" +
            "\t\t\tmovie_cinema\n" +
            "\t\tWHERE\n" +
            "\t\t\tmovie_cinema.movies = (\n" +
            "\t\t\t\tSELECT\n" +
            "\t\t\t\t\tto_be_released.movie\n" +
            "\t\t\t\tFROM\n" +
            "\t\t\t\t\tto_be_released\n" +
            "\t\t\t\tWHERE\n" +
            "\t\t\t\t\tto_be_released.movie = ?1\n" +
            "\t\t\t\tAND datediff(\n" +
            "\t\t\t\t\tto_be_released.play_time,\n" +
            "\t\t\t\t\tNOW()\n" +
            "\t\t\t\t) >= 0\n" +
            "\t\t\t\tAND datediff(\n" +
            "\t\t\t\t\tto_be_released.play_time,\n" +
            "\t\t\t\t\tNOW()\n" +
            "\t\t\t\t) <= 3\n" +
            "\t\t\t)\n" +
            "\t)")
    long CountCinemaByMovieId(int movieId);

    @Query(nativeQuery = true,
    value = "SELECT * FROM cinema WHERE cinema.`user` = ?1")
    List<Cinema> findCinemasByUser(int userId);

}
