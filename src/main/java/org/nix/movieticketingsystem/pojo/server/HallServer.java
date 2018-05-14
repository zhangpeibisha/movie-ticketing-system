package org.nix.movieticketingsystem.pojo.server;

import org.nix.movieticketingsystem.pojo.dao.CinemaRepository;
import org.nix.movieticketingsystem.pojo.dao.HallRepository;
import org.nix.movieticketingsystem.pojo.dao.MovieRepository;
import org.nix.movieticketingsystem.pojo.dao.SeatRepository;
import org.nix.movieticketingsystem.pojo.entity.*;
import org.nix.movieticketingsystem.web.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


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

    @Autowired
    private SeatServer seatServer;

    @Autowired
    private SeatRepository seatRepository;

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

    /**
     * 为电影院提案家影厅
     * @param user 电影商
     * @param cinemaId 电影院id
     * @param hallName 影厅名字
     * @param numberSeat 影厅座位数量
     * @return 操作结果
     */
    public boolean addHall(User user,int cinemaId,String hallName,int numberSeat){
        Cinema cinema = cinemaRepository.findCinemasById(cinemaId);
        if (cinema != null && cinema.getUser().getAccount().equals(user.getAccount())) {
            Hall hall = new Hall();
            hall.setCinema(cinema);
            hall.setHallName(hallName);
            List<Seat> seats = seatServer.createSeats(numberSeat);
            for (Seat seat : seats) {
                seat.setHall(hall);
            }
            seatRepository.saveAll(seats);
            return true;
        }
        return false;
    }

}
