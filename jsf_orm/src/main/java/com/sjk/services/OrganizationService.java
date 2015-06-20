package com.sjk.services;

import com.sjk.model.Organization;
import com.sjk.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Sebastian on 2015-06-17.
 */
public class OrganizationService {

    public boolean create(Organization org){
        //todo add validations by server side
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.save(org);
        session.close();
        return true;
    }
    public boolean delete(Organization org){
       Session session=HibernateUtils.getSessionFactory().getCurrentSession();
       Transaction trans=session.beginTransaction();
  	   session.delete(org);
  	   trans.commit();
       return true;
    }

    public boolean update(Organization org){
        
	   Session session=HibernateUtils.getSessionFactory().getCurrentSession();
       Transaction trans=session.beginTransaction();
	   session.update(org);
	   trans.commit();
       return true;
    }

    public List<Organization> getAllOrganizations(){

        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
    	Transaction trans=session.beginTransaction();
    	List<Organization> list = session.createCriteria(Organization.class).list();
    	trans.commit();
        return list;
    }
   
}
