package org.nix.movieticketingsystem.pojo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.Type;
import org.nix.movieticketingsystem.pojo.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/11.
 * <p>
 * 订单实体
 */
@Entity
@Table(name = "UserOrder")
public class Order extends BaseEntity {

    /**
     * 用户下单想要观看的电影
     */
    private Movie movie;
    /**
     * 放映影厅
     */
    private Hall hall;
    /**
     * 指定影院
     */
    private Cinema cinema;
    /**
     * 播放时间
     */
    private Date playTime;
    /**
     * 订单金额
     */
    private double money;
    /**
     * 下单用户
     */
    private User user;

    /**
     * 是否支付
     */
    private boolean isPayment = false;

    /**
     * 购买的座位
     */
    private List<BuySeat> buySeat;

    @ManyToOne(targetEntity = Movie.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie")
    public Movie getMovie() {
        return movie;
    }

    @ManyToOne(targetEntity = Hall.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "hall")
    public Hall getHall() {
        return hall;
    }

    @ManyToOne(targetEntity = Cinema.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema")
    public Cinema getCinema() {
        return cinema;
    }

    @Column(name = "playTime", length = 19, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getPlayTime() {
        return playTime;
    }

    @Column(name = "money")
    public double getMoney() {
        return money;
    }

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    public User getUser() {
        return user;
    }

    @Column(name = "isPayment")
    @Type(type = "yes_no")
    public boolean isPayment() {
        return isPayment;
    }

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JSONField(serialize = false)
    public List<BuySeat> getBuySeat() {
        return buySeat;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPayment(boolean payment) {
        isPayment = payment;
    }

    public void setBuySeat(List<BuySeat> buySeat) {
        this.buySeat = buySeat;
    }
}
