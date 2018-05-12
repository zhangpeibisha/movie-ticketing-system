package org.nix.movieticketingsystem.pojo.entity;

import org.hibernate.validator.constraints.Length;
import org.nix.movieticketingsystem.commons.enums.RoleEnum;
import org.nix.movieticketingsystem.pojo.entity.base.BaseEntity;

import javax.persistence.*;

/**
 * Create by zhangpe0312@qq.com on 2018/5/11.
 * <p>
 * 用户实体
 */
@Entity
@Table(name = "User")
public class User extends BaseEntity {

    private String account;
    private String password;
    private Double money;
    private RoleEnum role;

    /**
     * 账号唯一
     * 长度为 5-17位长
     */
    @Column(name = "account", unique = true, nullable = false, length = 18)
    @Length(min = 5, max = 18)
    public String getAccount() {
        return account;
    }

    /**
     * 密码加密，必为32位
     */
    @Column(name = "password", nullable = false, length = 32)
    @Length(min = 32, max = 33)
    public String getPassword() {
        return password;
    }

    /**
     * 如果为NULL则表示没有钱
     * 最小值为0
     */
    @Column(name = "money")
    @Length(min = 0)
    public Double getMoney() {
        return money;
    }

    @Column(name = "role",nullable = false)
    @Enumerated(EnumType.STRING)
    public RoleEnum getRole() {
        return role;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", role=" + role +
                '}';
    }
}
