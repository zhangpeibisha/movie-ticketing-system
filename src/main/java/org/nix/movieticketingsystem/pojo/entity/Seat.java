package org.nix.movieticketingsystem.pojo.entity;

import org.hibernate.annotations.Type;
import org.nix.movieticketingsystem.pojo.entity.base.BaseEntity;

import javax.persistence.*;

/**
 * Create by zhangpe0312@qq.com on 2018/5/11.
 * <p>
 * 座位实体
 */
@Entity
@Table(name = "Seat")
public class Seat extends BaseEntity {

    private Integer x;
    private Integer y;
    private boolean isBuy;
    private Hall hall;

    @Column(name = "x")
    public Integer getX() {
        return x;
    }

    @Column(name = "y")
    public Integer getY() {
        return y;
    }

    @Column(name = "isBuy")
    @Type(type = "yes_no")
    public boolean isBuy() {
        return isBuy;
    }

    /**
     * 一个影厅有多个座位，一个座位只属于一个影厅
     */
    @ManyToOne(targetEntity = Hall.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "hall")
    public Hall getHall() {
        return hall;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setBuy(boolean buy) {
        isBuy = buy;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
