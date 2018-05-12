package org.nix.movieticketingsystem.pojo.entity;

import org.hibernate.validator.constraints.Length;
import org.nix.movieticketingsystem.pojo.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Create by zhangpe0312@qq.com on 2018/5/11.
 *
 * 影片实体
 */
@Entity
@Table(name = "Movie")
public class Movie extends BaseEntity {

    private String movieName;
    private int hot;

    @Column(name = "movieName",nullable = false,length = 20)
    @Length(min = 1)
    public String getMovieName() {
        return movieName;
    }

    @Column(name = "hot")
    public int getHot() {
        return hot;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }
}
