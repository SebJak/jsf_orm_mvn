package com.sjk.services;

import com.sjk.model.Organization;
import com.sjk.model.embedded.OrganizationContext;
import com.sjk.utils.HibernateUtils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 2015-06-17.
 */
public class OrganizationService {

    public boolean create(Organization org){
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.save(org);
        session.close();
        return true;
    }

    public boolean delete(Organization org){
       Session session=HibernateUtils.getSessionFactory().openSession();
       Transaction trans=session.beginTransaction();
  	   session.delete(org);
  	   trans.commit();
       session.close();
       return true;
    }

    public boolean update(Organization org){
        
	   Session session=HibernateUtils.getSessionFactory().openSession();
       Transaction trans=session.beginTransaction();
	   session.update(org);
	   trans.commit();
       session.close();
       return true;
    }

    public List<Organization> getAllOrganizations(){

        Session session = HibernateUtils.getSessionFactory().openSession();
    	Transaction trans=session.beginTransaction();
    	List<Organization> list = session.createCriteria(Organization.class).list();
    	trans.commit();
        session.close();
        return list;
    }

    public List<Organization> getSupplierOrganizations(){
        return findOrganizationByContext(OrganizationContext.SUPPLIER);
    }


    public List<Organization> getCustomerOrganizations(){
        return findOrganizationByContext(OrganizationContext.CUSTOMER);
    }

    public List<Organization> findOrganizationByContext(OrganizationContext type){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Query queryOrganizations = session.getNamedQuery("Organization.findByContext");
        queryOrganizations.setParameter("context", type);
        List<Organization> orgs = queryOrganizations.list();
        tr.commit();
        session.close();
        return null==orgs?new ArrayList<Organization>():orgs;
    }




}
