package org.nix.movieticketingsystem.pojo.server;

import org.nix.movieticketingsystem.pojo.dao.CinemaRepository;
import org.nix.movieticketingsystem.pojo.dao.MovieRepository;
import org.nix.movieticketingsystem.pojo.dao.entitymanger.session.CinemaDao;
import org.nix.movieticketingsystem.pojo.dto.FindCinemaByMovieId;
import org.nix.movieticketingsystem.pojo.dto.base.BaseResultDto;
import org.nix.movieticketingsystem.pojo.entity.Cinema;
import org.nix.movieticketingsystem.pojo.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 */
@Service
public class CinemaServer {

    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CinemaDao cinemaDao;

    public BaseResultDto findCinemaByMoviePage(int movieId, int curr, int limit) {

        List<Cinema> cinemas = cinemaDao.findAllCinameByMovieId(movieId, curr, limit);
        long countCinema = cinemaRepository.CountCinemaByMovieId(movieId);
        Movie movie = movieRepository.getOne(movieId);
        return new FindCinemaByMovieId(countCinema,curr,limit,cinemas,movie).result();
    }

}
