package com.sjk.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by Sebastian on 2015-05-22.
 */
@ManagedBean
@SessionScoped
public class LoginCreadentials  implements Serializable{

    private String username;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String login(){
        // TODO
        /*
        Add check that user has privileges to login.
         */
        return "main";
    }
}
