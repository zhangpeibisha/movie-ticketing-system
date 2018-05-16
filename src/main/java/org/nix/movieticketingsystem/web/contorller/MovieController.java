package org.nix.movieticketingsystem.web.contorller;

import org.nix.movieticketingsystem.commons.enums.RoleEnum;
import org.nix.movieticketingsystem.commons.utils.ResultMvcMap;
import org.nix.movieticketingsystem.pojo.dao.MovieRepository;
import org.nix.movieticketingsystem.pojo.entity.Movie;
import org.nix.movieticketingsystem.pojo.server.MovieServer;
import org.nix.movieticketingsystem.web.annotation.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
     *
     * @return 查询结果
     */
    @GetMapping(value = "/findTopMovie")
    public Map<String, Object> findTopMovie(@RequestParam("count") int count) {

        return new ResultMvcMap()
                .success(movieServer.findTopTenMovie(count))
                .send();
    }


    @GetMapping(value = "/findMovieById")
    public Map<String, Object> findMovieById(@RequestParam("movieId") int movieId) {

        return new ResultMvcMap()
                .success(movieServer.findMovieById(movieId))
                .send();
    }

    /**
     * 管理员新增一个影片
     *
     * @return 操作结果
     */
    @PostMapping(value = "/addMovie")
    @Authority(role = RoleEnum.ROLE_MANGER)
    public Map<String, Object> addMovie(@RequestParam(value = "picture" , required = false) MultipartFile picture,
                                        @RequestParam("movieName") String movieName,
                                        @RequestParam("director") String director,
                                        @RequestParam("starring") String starring,
                                        @RequestParam("movieType") String movieType,
                                        @RequestParam("hot") int hot,
                                        @RequestParam("score") double score,
                                        HttpServletRequest request) {

        Movie movie = new Movie();
        movie.setStarring(starring);
        movie.setScore(score);
        movie.setMovieName(movieName);
        movie.setHot(hot);
        movie.setDirector(director);
        movie.setMovieType(movieType);

        if (movieServer.addMovie(movie, picture, request)) {
            return new ResultMvcMap()
                    .success()
                    .send();
        } else {
            return new ResultMvcMap()
                    .fail(HttpStatus.BAD_REQUEST, "文件上传失败")
                    .send();
        }
    }


}
