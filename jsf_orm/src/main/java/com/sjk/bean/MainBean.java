package com.sjk.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Sebastian on 2015-06-16.
 */
@ManagedBean
@SessionScoped
public class MainBean {


    public String createUser(){
        return "createUser";
    }

    public String createOrg(){
        return "createOrg";
    }
}