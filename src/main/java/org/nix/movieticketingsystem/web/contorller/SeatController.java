package org.nix.movieticketingsystem.web.contorller;

import org.nix.movieticketingsystem.commons.utils.ResultMvcMap;
import org.nix.movieticketingsystem.pojo.server.SeatServer;
import org.nix.movieticketingsystem.web.annotation.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 */
@RestController
@RequestMapping(value = "/seat")
public class SeatController {

    @Autowired
    private SeatServer seatServer;

    /**
     * 查询该场次电影影厅的所有座位
     * @param toBeReleasedId
     * @return
     */
    @GetMapping(value = "/findSeatByTobeReleased")
    public Map<String,Object> findSeatByTobeReleased(int toBeReleasedId){

        return new ResultMvcMap()
                .success(seatServer.findSeatByTobeReleased(toBeReleasedId))
                .send();
    }
}
