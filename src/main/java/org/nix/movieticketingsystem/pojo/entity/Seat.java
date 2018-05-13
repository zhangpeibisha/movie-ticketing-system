package org.nix.movieticketingsystem.pojo.entity;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.nix.movieticketingsystem.pojo.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/11.
 * <p>
 * 座位实体
 */
@Entity
@Table(name = "Seat")
public class Seat extends BaseEntity {

    private String Numbering; // 编号
    private Hall hall; // 所属影厅

    @Column(name = "Numbering", nullable = false, length = 20)
    @Length(min = 1)
    public String getNumbering() {
        return Numbering;
    }

    /**
     * 一个影厅有多个座位，一个座位只属于一个影厅
     */
    @ManyToOne(targetEntity = Hall.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "hall")
    public Hall getHall() {
        return hall;
    }

    public void setNumbering(String numbering) {
        Numbering = numbering;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

}
