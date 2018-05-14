package org.nix.movieticketingsystem.pojo.dao;

import org.nix.movieticketingsystem.pojo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by zhangpe0312@qq.com on 2018/5/12.
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 用户登陆
     *
     * @param account  用户账号
     * @param password 用户密码
     * @return 用户信息
     */
    @Query(nativeQuery = true,
            value = "SELECT * FROM `user` WHERE `user`.account = ?1 AND `user`.`password` = ?2 ")
    User login(String account, String password);

    @Query(nativeQuery = true,
            value = "SELECT * FROM `user` WHERE `user`.account = ?1")
    User findByAccount(String account);

    @Query(nativeQuery = true,
            value = "SELECT * FROM `user` WHERE `user`.id = ?1")
    User findUserById(int userId);
}
