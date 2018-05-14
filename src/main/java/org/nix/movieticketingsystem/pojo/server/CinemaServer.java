package org.nix.movieticketingsystem.pojo.server;

import org.nix.movieticketingsystem.commons.enums.RoleEnum;
import org.nix.movieticketingsystem.pojo.dao.CinemaRepository;
import org.nix.movieticketingsystem.pojo.dao.MovieRepository;
import org.nix.movieticketingsystem.pojo.dao.entitymanger.session.CinemaDao;
import org.nix.movieticketingsystem.pojo.dto.FindCinemaByMovieIdDto;
import org.nix.movieticketingsystem.pojo.dto.FindCinemasByUserDto;
import org.nix.movieticketingsystem.pojo.dto.base.BaseResultDto;
import org.nix.movieticketingsystem.pojo.entity.Cinema;
import org.nix.movieticketingsystem.pojo.entity.Movie;
import org.nix.movieticketingsystem.pojo.entity.User;
import org.nix.movieticketingsystem.web.annotation.Authority;
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
        return new FindCinemaByMovieIdDto(countCinema,curr,limit,cinemas,movie).result();
    }


    public BaseResultDto findCinemasByUser(User user){
        List<Cinema> cinemas = cinemaRepository.findCinemasByUser(user.getId());
        return new FindCinemasByUserDto(cinemas).result();
    }

    /**
     * 为电影商自己的电影院添加电影
     * @param user 电影商
     * @param cinemaId 电影院id
     * @param movieId 电影id
     * @return 操作成功会返回true否则返回false
     */
    @Authority(role = RoleEnum.ROLE_CINEMA)
    public boolean addMovie(User user,int cinemaId,int movieId){
        List<Cinema> cinemas = cinemaRepository.findCinemasByUser(user.getId());
        for (Cinema cinema : cinemas) {
            if (cinema.getId() == cinemaId){
                Movie movie = movieRepository.findMovieById(movieId);
                if (movie == null){
                    return false;
                }else {
                    cinema.getMovies().add(movie);
                    movieRepository.save(movie);
                    return true;
                }
            }
        }
        return false;
    }
}
