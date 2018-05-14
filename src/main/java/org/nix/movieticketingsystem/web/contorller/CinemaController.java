package org.nix.movieticketingsystem.web.contorller;

import org.nix.movieticketingsystem.commons.enums.RoleEnum;
import org.nix.movieticketingsystem.commons.utils.ResultMvcMap;
import org.nix.movieticketingsystem.pojo.dao.CinemaRepository;
import org.nix.movieticketingsystem.pojo.entity.Cinema;
import org.nix.movieticketingsystem.pojo.entity.User;
import org.nix.movieticketingsystem.pojo.server.CinemaServer;
import org.nix.movieticketingsystem.pojo.server.MovieServer;
import org.nix.movieticketingsystem.web.annotation.Authority;
import org.nix.movieticketingsystem.web.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Create by zhangpe0312@qq.com on 2018/5/13.
 */
@RestController
@RequestMapping(value = "/cinema")
public class CinemaController {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private CinemaServer cinemaServer;
    @Autowired
    private MovieServer movieServer;

    /**
     * 用户添加自己拥有的电影
     *
     * @param user
     * @param cinema
     * @return
     */
    @PostMapping(value = "/addCinema")
    @Authority(role = RoleEnum.ROLE_CINEMA)
    public Map<String, Object> addCinema(@CurrentUser User user,
                                         @ModelAttribute Cinema cinema) {
        cinema.setUser(user);
        cinemaRepository.save(cinema);
        return new ResultMvcMap()
                .success()
                .send();
    }

    /**
     * 通过电影id查询能够播放的电影院和场次
     *
     * @param movieId 电影id
     * @param curr    当前页
     * @param limit   每页数量
     * @return 通过电影id查询能够播放的电影院和场次
     */
    @GetMapping(value = "/findCountCinemaByMovieId")
    public Map<String, Object> findCountCinemaByMovieId(@RequestParam("movie") int movieId,
                                                        @RequestParam("curr") int curr,
                                                        @RequestParam("limit") int limit) {
        return new ResultMvcMap()
                .success(cinemaServer.findCinemaByMoviePage(movieId, curr, limit))
                .send();
    }

    /**
     * 用户查看自己所拥有的所有电影院
     *
     * @param user 电影商
     * @return 电影商拥有的电影院
     */
    @GetMapping(value = "/findCinemasByUser")
    @Authority(role = RoleEnum.ROLE_CINEMA)
    public Map<String, Object> findCinemasByUser(@CurrentUser User user) {
        return new ResultMvcMap()
                .success(cinemaServer.findCinemasByUser(user))
                .send();
    }

    /**
     * 为自己的电影院添加电影
     * @param user 电影院用户
     * @param movieId 新增电影
     * @return 操作结果
     */
    @PostMapping(value = "/addMovie")
    @Authority(role = RoleEnum.ROLE_CINEMA)
    public Map<String,Object> addMovie(@CurrentUser User user,
                                       @RequestParam("movie") int movieId,
                                       @RequestParam("cinema")int cinemaId){
        if (cinemaServer.addMovie(user,cinemaId,movieId)){
            return new ResultMvcMap()
                    .success()
                    .send();
        }else {
            return new ResultMvcMap()
                    .fail(HttpStatus.NOT_FOUND,"没有找到该电影院或者电影信息")
                    .send();
        }
    }


}
