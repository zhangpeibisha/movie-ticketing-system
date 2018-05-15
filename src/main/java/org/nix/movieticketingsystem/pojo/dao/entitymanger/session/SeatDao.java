package org.nix.movieticketingsystem.pojo.dao.entitymanger.session;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.nix.movieticketingsystem.pojo.dao.entitymanger.base.BaseEntityManger;
import org.nix.movieticketingsystem.pojo.entity.Seat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/15.
 */
@Transactional
@Service
public class SeatDao extends BaseEntityManger {


    public List<Seat> findSeatsByIds(int[] seatsId){

        StringBuilder stringBuilder = new StringBuilder();

        for(int values : seatsId){
            stringBuilder.append(values).append(",");
        }

        stringBuilder.substring(0,stringBuilder.lastIndexOf(","));

        String sql = "SELECT * FROM seat WHERE seat.hall In(ids)"
                .replace("ids",stringBuilder);
        Session session = getSession();
        Query query = session.createNativeQuery(sql);
        return query.getResultList();
    }

}
