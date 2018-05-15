package org.nix.movieticketingsystem.pojo.entity;

import org.nix.movieticketingsystem.pojo.entity.base.BaseEntity;

import javax.persistence.*;

/**
 * Create by zhangpe0312@qq.com on 2018/5/13.
 * <p>
 * 已经购买座位的信息实体
 */
@Entity
@Table(name = "BuySeat")
public class BuySeat extends BaseEntity {

    private Order order; // 购买这个座位的订单
    private Seat seat; // 购买的座位
    private ToBeReleased toBeReleased; // 购买的场次

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "BuyOrder")
    public Order getOrder() {
        return order;
    }

    @ManyToOne(targetEntity = Seat.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "seat")
    public Seat getSeat() {
        return seat;
    }

    @ManyToOne(targetEntity = ToBeReleased.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "toBeReleased")
    public ToBeReleased getToBeReleased() {
        return toBeReleased;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setToBeReleased(ToBeReleased toBeReleased) {
        this.toBeReleased = toBeReleased;
    }
}
