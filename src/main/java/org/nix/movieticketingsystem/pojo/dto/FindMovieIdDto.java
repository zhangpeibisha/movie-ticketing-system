package org.nix.movieticketingsystem.pojo.dto;

import org.nix.movieticketingsystem.pojo.dto.base.AbstractBaseResultDto;
import org.nix.movieticketingsystem.pojo.entity.Movie;

/**
 * Create by zhangpe0312@qq.com on 2018/5/16.
 */
public class FindMovieIdDto extends AbstractBaseResultDto {

    private Movie movie;

    public FindMovieIdDto(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void handler() {
        movie.setCinemas(null);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
