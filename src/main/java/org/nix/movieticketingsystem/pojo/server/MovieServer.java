package org.nix.movieticketingsystem.pojo.server;

import org.nix.movieticketingsystem.pojo.dao.MovieRepository;
import org.nix.movieticketingsystem.pojo.dto.FindTopMovie;
import org.nix.movieticketingsystem.pojo.dto.base.BaseResultDto;
import org.nix.movieticketingsystem.pojo.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 */
@Service
public class MovieServer {

    @Autowired
    private MovieRepository movieRepository;

    public BaseResultDto findTopTenMovie(int countMovie){
        List<Movie> movies = movieRepository.finHotMovieList(countMovie);
        return new FindTopMovie(movies).result();
    }

}
