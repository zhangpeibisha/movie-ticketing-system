package org.nix.movieticketingsystem.web.contorller;

import org.nix.movieticketingsystem.commons.utils.ResultMvcMap;
import org.nix.movieticketingsystem.pojo.dao.MovieRepository;
import org.nix.movieticketingsystem.pojo.server.MovieServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 */
@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieServer movieServer;

    /**
     * 发现热度前几的电影
     * @return 查询结果
     */
    @GetMapping(value = "/findTopMovie")
    public Map<String,Object> findTopMovie(@RequestParam("count")int count){

        return new ResultMvcMap()
                .success(movieServer.findTopTenMovie(count))
                .send();
    }
}
