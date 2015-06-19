package com.sjk.services;

import com.sjk.model.Organization;
import com.sjk.model.Product;
import com.sjk.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Sebastian on 2015-06-17.
 */
public class ProductService {

    public boolean create(Product pro){
        //todo add validations by server side
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.save(pro);
        session.close();
        return true;
    }
    public boolean delete(Product pro){
       Session session=HibernateUtils.getSessionFactory().getCurrentSession();
       Transaction trans=session.beginTransaction();
  	   session.delete(pro);
  	   trans.commit();
       return true;
    }

    public boolean update(Product pro){
        
	   Session session=HibernateUtils.getSessionFactory().getCurrentSession();
       Transaction trans=session.beginTransaction();
	   session.update(pro);
	   trans.commit();
       return true;
    }

    public List<Product> getAllProducts(){
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
    	Transaction trans=session.beginTransaction();
    	List<Product> list = session.createCriteria(Organization.class).list();
    	trans.commit();
        return list;
    }
   
}
