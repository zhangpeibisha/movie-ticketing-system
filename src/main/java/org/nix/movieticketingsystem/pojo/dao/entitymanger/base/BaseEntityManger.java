package org.nix.movieticketingsystem.pojo.dao.entitymanger.base;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Create by zhangpe0312@qq.com on 2018/5/12.
 */
@Transactional
public class BaseEntityManger {

    @PersistenceContext
    private EntityManager entityManger;

    public Session getSession(){
        return entityManger.unwrap(org.hibernate.Session.class);
    }

}
