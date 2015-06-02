package com.sjk.bean;

import com.sjk.model.User;
import com.sjk.utils.PasswordUtils;

import javax.faces.bean.ManagedBean;

/**
 * Created by Sebastian on 2015-06-02.
 */
@ManagedBean
public class CreateUser {

    private User newUser;

    private PasswordUtils password;

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public PasswordUtils getPassword() {
        return password;
    }

    public void setPassword(PasswordUtils password) {
        this.password = password;
    }

    public String createUser(){

        return null;
    }

    public boolean validateLogin(){

        return true;
    }
}
