package org.nix.movieticketingsystem.web.contorller;

import org.nix.movieticketingsystem.commons.enums.RoleEnum;
import org.nix.movieticketingsystem.commons.enums.SessionEnum;
import org.nix.movieticketingsystem.commons.utils.ResultMvcMap;
import org.nix.movieticketingsystem.pojo.dao.UserRepository;
import org.nix.movieticketingsystem.pojo.entity.User;
import org.nix.movieticketingsystem.pojo.server.UserServer;
import org.nix.movieticketingsystem.web.annotation.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Create by zhangpe0312@qq.com on 2018/5/13.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServer userServer;

    @GetMapping(value = "/login")
    public Map<String, Object> login(@RequestParam(value = "account") String account,
                                     @RequestParam(value = "password") String password,
                                     HttpSession session) {
        User user = userRepository.login(account, password);
        if (user == null) {
            return new ResultMvcMap()
                    .fail(HttpStatus.NOT_FOUND, "不存在这个用户")
                    .send();
        } else {
            session.setAttribute(SessionEnum.SESSION_USER.getKey(), user);
            return new ResultMvcMap()
                    .success()
                    .send();
        }
    }

    @PostMapping(value = "/register")
    public Map<String, Object> register(@RequestParam(value = "account") String account,
                                        @RequestParam(value = "password") String password) {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setRole(RoleEnum.ROLE_USER);
        userRepository.save(user);
        return new ResultMvcMap()
                .success()
                .send();
    }

    /**
     * 更新角色
     *
     * @return
     */
    @Authority(role = RoleEnum.ROLE_MANGER)
    @PostMapping(value = "/updateRole")
    public Map<String, Object> updateRole(@RequestParam("role") String roleName, @RequestParam("user") int user) {
        if (userServer.updateRole(roleName,user))
            return new ResultMvcMap()
            .success()
            .send();

        return new ResultMvcMap()
                .fail(HttpStatus.NOT_FOUND,"没有找到需要更新的用户或者角色")
                .send();
    }


}
