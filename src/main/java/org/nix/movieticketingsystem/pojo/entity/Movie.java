package org.nix.movieticketingsystem.pojo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.Length;
import org.nix.movieticketingsystem.pojo.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/11.
 * <p>
 * 影片实体
 */
@Entity
@Table(name = "Movie")
public class Movie extends BaseEntity {

    private String movieName; // 名字
    private int hot; // 热度
    private double score; //评分
    private String director; // 导演
    private String starring; // 主演
    private String pictureUrl; // 电影海报图片地址
    private List<Cinema> cinemas; // 电影和电影院多对多
    private String movieType; //电影类型

    @Column(name = "movieName", nullable = false, length = 20)
    @Length(min = 1)
    public String getMovieName() {
        return movieName;
    }

    @Column(name = "hot")
    public int getHot() {
        return hot;
    }

    @Column(name = "score")
    public double getScore() {
        return score;
    }

    @Column(name = "director", nullable = false, length = 20)
    @Length(min = 1)
    public String getDirector() {
        return director;
    }

    @Column(name = "starring", nullable = false, length = 20)
    @Length(min = 1)
    public String getStarring() {
        return starring;
    }

    @Column(name = "pictureUrl", nullable = false, length = 200)
    @Length(min = 1)
    public String getPictureUrl() {
        return pictureUrl;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "movie_cinema"
            , joinColumns = {@JoinColumn(name = "movies")}
            , inverseJoinColumns = {@JoinColumn(name = "cinemas")})
    @JSONField(serialize = false)
    public List<Cinema> getCinemas() {
        return cinemas;
    }

    @Column(name = "movieType",length = 20)
    public String getMovieType() {
        return movieType;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }
}
