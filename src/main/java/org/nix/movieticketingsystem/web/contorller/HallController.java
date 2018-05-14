package org.nix.movieticketingsystem.web.contorller;

import org.nix.movieticketingsystem.pojo.entity.User;
import org.nix.movieticketingsystem.web.annotation.CurrentUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 */
@RestController
@RequestMapping(value = "/hall")
public class HallController {

    /**
     * 电影商给自己的影院的影厅添加待放映电影
     * @param user 电影商
     * @param cinemaId 电影院id
     * @param hallId 影厅id
     * @param movieId 影片id
     * @return 操作结果
     */
    public Map<String, Object> addToBeReleased(@CurrentUser User user, int cinemaId, int hallId, int movieId) {

        return null;
    }
}
