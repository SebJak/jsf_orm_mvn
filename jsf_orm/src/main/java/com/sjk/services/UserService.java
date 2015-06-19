package com.sjk.services;

import com.sjk.model.Organization;
import com.sjk.model.User;
import com.sjk.utils.HibernateUtils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.List;

/**
 * Created by Sebastian on 2015-06-17.
 */

public class UserService {

    public boolean createUser(User user){
        //TODO add validations
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.save(user);
        session.close();
        return true;
    }

    public boolean deleteUser(User user){
    	 Session session=HibernateUtils.getSessionFactory().getCurrentSession();
         Transaction trans=session.beginTransaction();
    	 session.delete(user);
    	 trans.commit();
         return true;
    }

    public boolean updateUser(User user){
    	Session session=HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction trans=session.beginTransaction();
  	    session.update(user);
  	    trans.commit();
        return true;
    }

    public List<User> findUserByName(String name){
        //TODO complete
        return null;
    }

    public List<User> findByOrganization(Organization organization){
        //TODO complete
        return null;
    }

    public User login(String login, String password){

        Session session = HibernateUtils.getSessionFactory().openSession();
        Query queryUserByLogin = session.getNamedQuery("User.findByLogin");
        queryUserByLogin.setParameter("login", login);
        List<User> users = queryUserByLogin.list();
        if(users!=null && users.size()>0){
            User user = users.get(0);
            if(user.getPassword().equals(password))
                return user;
        }
        return null;
    }
    
    public List<User> getAllUsers(){
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
    	Transaction trans=session.beginTransaction();
    	List<User> list = session.createCriteria(User.class).list();
    	trans.commit();
        return list;
    }
}
