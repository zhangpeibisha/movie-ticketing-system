package org.nix.movieticketingsystem.web.contorller;

import org.nix.movieticketingsystem.commons.enums.RoleEnum;
import org.nix.movieticketingsystem.commons.utils.ResultMvcMap;
import org.nix.movieticketingsystem.pojo.dao.MovieRepository;
import org.nix.movieticketingsystem.pojo.entity.Movie;
import org.nix.movieticketingsystem.pojo.entity.User;
import org.nix.movieticketingsystem.pojo.server.MovieServer;
import org.nix.movieticketingsystem.web.annotation.Authority;
import org.nix.movieticketingsystem.web.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 管理员新增一个影片
     * @param movie 影片对象实体
     * @return 操作结果
     */
    @PostMapping(value = "/addMovie")
    @Authority(role = RoleEnum.ROLE_MANGER)
    public Map<String,Object> addMovie(@ModelAttribute Movie movie){
        movieRepository.save(movie);

        return new ResultMvcMap()
                .success()
                .send();
    }


}
