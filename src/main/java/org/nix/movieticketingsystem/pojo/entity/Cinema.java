package org.nix.movieticketingsystem.pojo.entity;

import org.hibernate.validator.constraints.Length;
import org.nix.movieticketingsystem.pojo.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Create by zhangpe0312@qq.com on 2018/5/11.
 *
 * 电影院实体
 */
@Entity
@Table(name = "Cinema")
public class Cinema extends BaseEntity {

    private String cinemaName;
    private String address;

    @Column(name = "cinemaName",nullable = false,length = 20)
    @Length(min = 1)
    public String getCinemaName() {
        return cinemaName;
    }

    @Column(name = "address",nullable = false,length = 50)
    @Length(min = 1)
    public String getAddress() {
        return address;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
