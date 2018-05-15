package org.nix.movieticketingsystem.pojo.dto;

import org.nix.movieticketingsystem.pojo.dto.base.AbstractBaseResultDto;
import org.nix.movieticketingsystem.pojo.entity.Seat;

import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 */
public class FindAllSeatsDto extends AbstractBaseResultDto {

    List<Seat> buyedSeats;
    List<Seat> allSeates;

    public FindAllSeatsDto(List<Seat> buyedSeats, List<Seat> allSeates) {
        this.buyedSeats = buyedSeats;
        this.allSeates = allSeates;
    }

    @Override
    public void handler() {

        for (Seat seat : allSeates) {
            seat.setHall(null);
        }

        for (Seat seat : buyedSeats) {
            seat.setHall(null);
        }

    }

    public List<Seat> getBuyedSeats() {
        return buyedSeats;
    }

    public void setBuyedSeats(List<Seat> buyedSeats) {
        this.buyedSeats = buyedSeats;
    }

    public List<Seat> getAllSeates() {
        return allSeates;
    }

    public void setAllSeates(List<Seat> allSeates) {
        this.allSeates = allSeates;
    }
}
