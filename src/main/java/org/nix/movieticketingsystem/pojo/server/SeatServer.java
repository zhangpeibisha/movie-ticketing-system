package org.nix.movieticketingsystem.pojo.server;

import org.nix.movieticketingsystem.pojo.dao.SeatRepository;
import org.nix.movieticketingsystem.pojo.dto.base.BaseResultDto;
import org.nix.movieticketingsystem.pojo.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 */
@Service
public class SeatServer {


    @Autowired
    private SeatRepository seatRepository;

    public BaseResultDto findSeatByTobeReleased(int toBeReleasedId){

        List<Seat> buyedSeats = seatRepository.findBuySeatByToBeReleasedId(toBeReleasedId);
        List<Seat> allSeates = seatRepository.findAllSeatByHallToBeReleasedId(toBeReleasedId);

        return null;
    }

    public List<Seat> createSeats(int number){

        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Seat seat = new Seat();
            String numbering = i + "号";
            seat.setNumbering(numbering);
            seats.add(seat);
        }
        return seats;
    }

}
