package org.nix.movieticketingsystem.pojo.server;

import org.nix.movieticketingsystem.commons.enums.RoleEnum;
import org.nix.movieticketingsystem.pojo.dao.UserRepository;
import org.nix.movieticketingsystem.pojo.entity.User;
import org.nix.movieticketingsystem.web.annotation.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 */
@Service
public class UserServer {

    @Autowired
    private UserRepository userRepository;

    /**
     * 若用户更新角色成功，则返回true
     * @param roleName 角色名字
     * @param user 用户id
     * @return 成功返回true,失败返回false
     */
    @Authority(role = RoleEnum.ROLE_MANGER)
    public boolean updateRole(String roleName,int user){

        User findUser = userRepository.findUserById(user);
        if (findUser == null)
            return false;
        try {
            RoleEnum roleEnum = RoleEnum.valueOf(roleName);
            findUser.setRole(roleEnum);
            userRepository.save(findUser);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
