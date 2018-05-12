package org.nix.movieticketingsystem.pojo.entity;

import org.hibernate.validator.constraints.Length;
import org.nix.movieticketingsystem.pojo.entity.base.BaseEntity;

import javax.persistence.*;

/**
 * Create by zhangpe0312@qq.com on 2018/5/11.
 *
 * 影厅实体
 */
@Entity
@Table(name = "Hall")
public class Hall extends BaseEntity {

    private String hallName;
    private Cinema cinema;

    @Column(name = "hallName",nullable = false,length = 20)
    @Length(min = 1)
    public String getHallName() {
        return hallName;
    }

    /**
     * 一个电影院拥有多个影厅，一个影厅只能属于一个影院
     */
    @ManyToOne(targetEntity = Cinema.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema")
    public Cinema getCinema() {
        return cinema;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
