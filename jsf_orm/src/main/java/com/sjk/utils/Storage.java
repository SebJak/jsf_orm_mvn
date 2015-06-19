package com.sjk.utils;

import com.sjk.model.embedded.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Sebastian on 2015-05-23.
 */
public class Storage <T extends BaseEntity> {
    public static SessionFactory getSessionFactory(){
        return HibernateUtils.getSessionFactory();
    }

    private T entity;
    private Session session;

    public void beginTransaction(){
        session = Storage.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public void commit(){
        session.getTransaction().commit();
    }
    public void update(T entity){
        session.update(entity);
    }
    public Long insert(T entity){
        return (Long) session.save(entity);
    }
    public void delete(T entity){
        session.delete(entity);
    }
}
