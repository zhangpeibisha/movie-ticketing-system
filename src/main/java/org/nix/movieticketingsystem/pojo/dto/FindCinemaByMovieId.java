package org.nix.movieticketingsystem.pojo.dto;

import org.nix.movieticketingsystem.pojo.dto.base.AbstractBaseResultDto;
import org.nix.movieticketingsystem.pojo.entity.Cinema;
import org.nix.movieticketingsystem.pojo.entity.Hall;
import org.nix.movieticketingsystem.pojo.entity.Movie;
import org.nix.movieticketingsystem.pojo.entity.ToBeReleased;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 *
 * 返回指定电影能够播放的电影院和播放场次
 */
public class FindCinemaByMovieId extends AbstractBaseResultDto {

    private long count;
    private int currPage;
    private int limit;
    private List<ResultCinema> resultCinemas = new ArrayList<>();
    private List<Cinema> cinemas;
    private Movie movie;

    public FindCinemaByMovieId(long count, int currPage, int limit, List<Cinema> cinemas, Movie movie) {
        this.count = count;
        this.currPage = currPage;
        this.limit = limit;
        this.cinemas = cinemas;
        this.movie = movie;
    }

    @Override
    public void handler() {
        for (Cinema cinema : cinemas) {
            cinema.setUser(null);
            cinema.setMovies(null);

            List<ToBeReleased> resultToBeReleased = new ArrayList<>();

            List<Hall> halls = cinema.getHalls();
            for (Hall hall : halls) {
                hall.setCinema(null);
                List<ToBeReleased> toBeReleaseds = hall.getToBeReleaseds();
                for (ToBeReleased toBeReleased : toBeReleaseds) {
                    if (toBeReleased.getMovie().getMovieName().equals(movie.getMovieName())){
                        toBeReleased.setHall(null);
                        resultToBeReleased.add(toBeReleased);
                    }
                }
            }

            ResultCinema resultCinema = new ResultCinema(cinema,resultToBeReleased);
            resultCinemas.add(resultCinema);
        }
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<ResultCinema> getResultCinemas() {
        return resultCinemas;
    }

    public void setResultCinemas(List<ResultCinema> resultCinemas) {
        this.resultCinemas = resultCinemas;
    }
}

class ResultCinema{

    private Cinema cinema;
    private List<ToBeReleased> toBeReleaseds;

    public ResultCinema(Cinema cinema, List<ToBeReleased> toBeReleaseds) {
        this.cinema = cinema;
        this.toBeReleaseds = toBeReleaseds;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public List<ToBeReleased> getToBeReleaseds() {
        return toBeReleaseds;
    }

    public void setToBeReleaseds(List<ToBeReleased> toBeReleaseds) {
        this.toBeReleaseds = toBeReleaseds;
    }
}
