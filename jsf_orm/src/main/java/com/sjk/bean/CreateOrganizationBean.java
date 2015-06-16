package com.sjk.bean;

import com.sjk.model.Organization;
import com.sjk.utils.HibernateUtils;
import org.hibernate.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Sebastian on 2015-06-16.
 */
@ManagedBean
@SessionScoped
public class CreateOrganizationBean {

    private Organization org;

    public  CreateOrganizationBean(){
        org = new Organization();
    }
    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }

    public void create(){
        //TODO create organization
        System.out.printf("Create Organization");
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.save(org);
        session.close();
    }
}
