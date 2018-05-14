package org.nix.movieticketingsystem.pojo.dto;

import org.nix.movieticketingsystem.pojo.dto.base.AbstractBaseResultDto;
import org.nix.movieticketingsystem.pojo.entity.Cinema;

import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 */
public class FindCinemasByUserDto extends AbstractBaseResultDto {

    private List<Cinema> cinemas;

    public FindCinemasByUserDto(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    @Override
    public void handler() {
        for (Cinema cinema : cinemas) {
            cinema.setMovies(null);
            cinema.setUser(null);
            cinema.setHalls(null);
        }
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }
}
