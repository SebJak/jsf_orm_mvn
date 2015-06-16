package com.sjk.bean;

import com.sjk.model.Organization;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Sebastian on 2015-06-16.
 */
@ManagedBean
@SessionScoped
public class CreateOrganizationBean {

    private Organization org;

    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }

    public void create(){
        //TODO create organization
        System.out.printf("Create Organization");
    }
}
