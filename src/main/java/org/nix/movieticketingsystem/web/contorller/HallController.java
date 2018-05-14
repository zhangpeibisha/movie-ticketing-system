package org.nix.movieticketingsystem.web.contorller;

import org.nix.movieticketingsystem.commons.enums.RoleEnum;
import org.nix.movieticketingsystem.commons.utils.ResultMvcMap;
import org.nix.movieticketingsystem.pojo.entity.User;
import org.nix.movieticketingsystem.pojo.server.HallServer;
import org.nix.movieticketingsystem.web.annotation.Authority;
import org.nix.movieticketingsystem.web.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 */
@RestController
@RequestMapping(value = "/hall")
public class HallController {

    @Autowired
    private HallServer hallServer;


    /**
     * 电影商给自己的影院的影厅添加待放映电影
     * @param user 电影商
     * @param cinemaId 电影院id
     * @param hallId 影厅id
     * @param movieId 影片id
     * @return 操作结果
     */
    @PostMapping(value = "/addToBeReleased")
    @Authority(role = RoleEnum.ROLE_CINEMA)
    public Map<String, Object> addToBeReleased(@CurrentUser User user,
                                               @RequestParam("cinema") int cinemaId,
                                               @RequestParam("hall") int hallId,
                                               @RequestParam("movie") int movieId,
                                               @RequestParam("money")double money,
                                               @RequestParam("playTime")long playTime) {
        if (hallServer.addToBeReleased(user,cinemaId,hallId,movieId,money,new Date(playTime))){
            return new ResultMvcMap()
                    .success()
                    .send();
        }else{
            return new ResultMvcMap()
                    .fail(HttpStatus.FORBIDDEN,"操作被拒绝")
                    .send();
        }
    }

    /**
     * 为电影院添加影厅
     * @param user 电影商
     * @param cinemaId 电影院id
     * @param hallName 放映厅名字
     * @param numberSeat 放映厅座位数量
     * @return 操作结果
     */
    @PostMapping(value = "/addHall")
    @Authority(role = RoleEnum.ROLE_CINEMA)
    public Map<String,Object> addHall(@CurrentUser User user,
                                      @RequestParam("cinemaId")int cinemaId,
                                      @RequestParam("hallName")String hallName,
                                      @RequestParam("numberSeat")int numberSeat){
       if (hallServer.addHall(user,cinemaId,hallName,numberSeat)){
           return new ResultMvcMap()
                   .success()
                   .send();
       }else {
           return new ResultMvcMap()
                   .fail(HttpStatus.FORBIDDEN,"操作被拒绝")
                   .send();
       }
    }
}
