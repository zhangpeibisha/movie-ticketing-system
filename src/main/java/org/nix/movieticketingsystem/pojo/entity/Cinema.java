package org.nix.movieticketingsystem.pojo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.Length;
import org.nix.movieticketingsystem.pojo.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/11.
 * <p>
 * 电影院实体
 */
@Entity
@Table(name = "Cinema")
public class Cinema extends BaseEntity {

    private String cinemaName;
    private String address;
    private List<Movie> movies;
    private User user; // 拥有人

    @Column(name = "cinemaName", nullable = false, length = 20)
    @Length(min = 1)
    public String getCinemaName() {
        return cinemaName;
    }

    @Column(name = "address", nullable = false, length = 50)
    @Length(min = 1)
    public String getAddress() {
        return address;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "movie_cinema"
            , joinColumns = {@JoinColumn(name = "cinemas")}
            , inverseJoinColumns = {@JoinColumn(name = "movies")})
    @JSONField(serialize = false)
    public List<Movie> getMovies() {
        return movies;
    }

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    public User getUser() {
        return user;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
