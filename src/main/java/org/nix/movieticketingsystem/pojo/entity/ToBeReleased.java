package org.nix.movieticketingsystem.pojo.entity;

import org.nix.movieticketingsystem.pojo.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Create by zhangpe0312@qq.com on 2018/5/11.
 * <p>
 * 待放电影
 */
@Entity
@Table(name = "ToBeReleased")
public class ToBeReleased extends BaseEntity {

    private Hall hall;
    private Date playTime;
    private Movie movie;
    private double money; // 当场观看电影需要的金额

    @ManyToOne(targetEntity = Hall.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "hall")
    public Hall getHall() {
        return hall;
    }

    @Column(name = "playTime", length = 19, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getPlayTime() {
        return playTime;
    }

    @ManyToOne(targetEntity = Movie.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie")
    public Movie getMovie() {
        return movie;
    }

    @Column(name = "money")
    public double getMoney() {
        return money;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}