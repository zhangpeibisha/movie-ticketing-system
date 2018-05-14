package org.nix.movieticketingsystem.web.contorller;

import org.nix.movieticketingsystem.commons.utils.ResultMvcMap;
import org.nix.movieticketingsystem.pojo.dao.CinemaRepository;
import org.nix.movieticketingsystem.pojo.entity.Cinema;
import org.nix.movieticketingsystem.pojo.entity.User;
import org.nix.movieticketingsystem.web.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Create by zhangpe0312@qq.com on 2018/5/13.
 */
@RestController
@RequestMapping(value = "/cinema")
public class CinemaController {

    @Autowired
    private CinemaRepository cinemaRepository;

    /**
     * 用户添加自己拥有的电影
     * @param user
     * @param cinema
     * @return
     */
    @PostMapping(value = "/addCinema")
    public Map<String,Object> addCinema(@CurrentUser User user,
                                        @ModelAttribute Cinema cinema){
        cinema.setUser(user);
        cinemaRepository.save(cinema);
        return new ResultMvcMap()
                .success()
                .send();

    }

}
