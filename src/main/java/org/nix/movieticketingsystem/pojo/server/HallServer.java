package org.nix.movieticketingsystem.pojo.server;

import org.nix.movieticketingsystem.pojo.dao.CinemaRepository;
import org.nix.movieticketingsystem.pojo.dao.HallRepository;
import org.nix.movieticketingsystem.pojo.dao.MovieRepository;
import org.nix.movieticketingsystem.pojo.entity.*;
import org.nix.movieticketingsystem.web.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 */
@Service
public class HallServer {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private HallRepository hallRepository;

    /**
     * 电影商为自己的电影院的指定影厅添加待放映电影
     *
     * @param user     电影商
     * @param cinemaId 电影院id
     * @param hallId   影厅id
     * @param movieId  电影id
     * @return 操作结果
     */
    public boolean addToBeReleased(User user, int cinemaId, int hallId, int movieId, double money, Date playTime) {
        Cinema cinema = cinemaRepository.findCinemasById(cinemaId);
        if (cinema != null && cinema.getUser().getAccount().equals(user.getAccount())) {
            Hall hall = hallRepository.findHallById(hallId);
            if (!cinema.getHalls().contains(hall))
                return false;

            Movie movie = movieRepository.findMovieById(movieId);
            if (movie == null)
                return false;

            if (!cinema.getMovies().contains(movie))
                return false;

            ToBeReleased toBeReleased = new ToBeReleased();
            toBeReleased.setHall(hall);
            toBeReleased.setMoney(money);
            toBeReleased.setMovie(movie);
            toBeReleased.setPlayTime(playTime);

            hall.getToBeReleaseds().add(toBeReleased);
            hallRepository.save(hall);
            return true;
        }
        return false;
    }

}
