package com.sjk.services;

import com.sjk.model.Organization;
import com.sjk.model.Product;
import com.sjk.utils.HibernateUtils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Sebastian on 2015-06-17.
 */
public class ProductService {

    public boolean create(Product pro){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.save(pro);
        tr.commit();
        session.close();
        return true;
    }
    public boolean delete(Product pro){
       Session session=HibernateUtils.getSessionFactory().openSession();
       Transaction trans=session.beginTransaction();
  	   session.delete(pro);
  	   trans.commit();
        session.close();
       return true;
    }

    public boolean update(Product pro){
        
	   Session session=HibernateUtils.getSessionFactory().openSession();
       Transaction trans=session.beginTransaction();
	   session.update(pro);
	   trans.commit();
       session.close();
       return true;
    }

    public List<Product> getAllProducts(){
    	Session session = HibernateUtils.getSessionFactory().openSession();
    	Transaction trans=session.beginTransaction();
    	List<Product> list = session.createCriteria(Organization.class).list();
    	trans.commit();
        session.close();
        return list;
    }

    public Product getProductByCode(String code){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Query queryUserByLogin = session.getNamedQuery("Product.findByCode");
        queryUserByLogin.setParameter("code", code);
        List<Product> products = queryUserByLogin.list();
        if(products!=null && products.size()>0){
            Product product = products.get(0);
            tr.commit();
            session.close();
            return  product;
        }
        tr.commit();
        session.close();
        return null;
    }
   
}
