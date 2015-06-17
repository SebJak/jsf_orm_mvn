package com.sjk.bean;

import com.sjk.model.User;
import com.sjk.services.UserService;
import com.sjk.utils.PasswordUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by Sebastian on 2015-06-02.
 */
@ManagedBean
@ViewScoped
public class CreateUser implements Serializable {

    private User newUser;

    private PasswordUtils password;

    private UserService userService;

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

    public CreateUser() {
        System.out.println("Created User");
        newUser = new User();
        password = new PasswordUtils();
        userService = new UserService();
    }

    public void create(){
        System.out.println("Method Create User");
        if(password.validatePassword()) {
            System.out.println("Pass validated");
            newUser.setPassword(password.getPassword());
            userService.createUser(newUser);
            System.out.println("User created");
        }
        else{
            System.out.println("Pass No validated");
        }

    }

    public boolean validateLogin(){

        return true;
    }
}
