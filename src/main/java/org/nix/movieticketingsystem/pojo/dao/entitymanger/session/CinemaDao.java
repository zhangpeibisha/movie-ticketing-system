package org.nix.movieticketingsystem.pojo.dao.entitymanger.session;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.nix.movieticketingsystem.pojo.dao.entitymanger.base.BaseEntityManger;
import org.nix.movieticketingsystem.pojo.dao.entitymanger.base.SupperBaseDAOImp;
import org.nix.movieticketingsystem.pojo.entity.Cinema;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/12.
 */
@Service
@Transactional
public class CinemaDao extends BaseEntityManger {
    /**
     * 通过电影名字查询最近能够放映的电影院,进行分页展示
     *
     * @param movieName 电影名字
     * @param curr      当前页
     * @param limit     每页多少行数据
     * @return 最近三天能够放映该电影电影院，指定页的数据
     */
    public List<Cinema> findAllByMovieName(String movieName, int curr, int limit) {

        if (curr < 1)
            return null;

        String sql = "SELECT\n" +
                "\t*\n" +
                "FROM\n" +
                "\tcinema\n" +
                "WHERE\n" +
                "\tid = (\n" +
                "\t\tSELECT\n" +
                "\t\t\tmovie_cinema.cinemas\n" +
                "\t\tFROM\n" +
                "\t\t\tmovie_cinema\n" +
                "\t\tWHERE\n" +
                "\t\t\tmovie_cinema.movies = (\n" +
                "\t\t\t\tSELECT\n" +
                "\t\t\t\t\tto_be_released.movie\n" +
                "\t\t\t\tFROM\n" +
                "\t\t\t\t\tto_be_released\n" +
                "\t\t\t\tWHERE\n" +
                "\t\t\t\t\tto_be_released.movie = 'movieName'\n" +
                "\t\t\t\tAND datediff(\n" +
                "\t\t\t\t\tto_be_released.play_time,\n" +
                "\t\t\t\t\tNOW()\n" +
                "\t\t\t\t) >= 0\n" +
                "\t\t\t\tAND datediff(\n" +
                "\t\t\t\t\tto_be_released.play_time,\n" +
                "\t\t\t\t\tNOW()\n" +
                "\t\t\t\t) <= 3\n" +
                "\t\t\t)\n" +
                "\t) LIMIT curr,limit";

        int currPage = (curr - 1) * limit;
        int limitRow = currPage + limit;
        sql = sql.replace("movieName", movieName)
                .replace("curr", currPage + "")
                .replace("limit", limitRow + "");

        Session session = getSession();
        Query query = session.createNativeQuery(sql);
        return query.getResultList();
    }

}
