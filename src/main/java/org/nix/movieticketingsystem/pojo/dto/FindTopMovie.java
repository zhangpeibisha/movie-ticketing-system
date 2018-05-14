package org.nix.movieticketingsystem.pojo.dto;

import org.nix.movieticketingsystem.pojo.dto.base.AbstractBaseResultDto;
import org.nix.movieticketingsystem.pojo.dto.base.BaseResultDto;
import org.nix.movieticketingsystem.pojo.entity.Movie;

import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 *
 * 返回电影的基础信息
 * 名字
 * 热度
 * 评分
 * 导演
 * 主演
 * 电影海报图片地址
 */
public class FindTopMovie extends AbstractBaseResultDto {

    private List<Movie> movies;

    public FindTopMovie(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public void handler() {
        for (int i = 0; i <movies.size() ; i++) {
            movies.get(i).setCinemas(null);
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
