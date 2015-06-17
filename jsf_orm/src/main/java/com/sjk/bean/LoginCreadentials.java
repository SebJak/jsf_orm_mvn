package com.sjk.bean;

import com.sjk.model.User;
import com.sjk.services.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by Sebastian on 2015-05-22.
 */
@ManagedBean
@SessionScoped
public class LoginCreadentials  implements Serializable{

    private String username;

    private String password;

    private UserService userService;

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

    public LoginCreadentials() {
        userService = new UserService();
    }

    public String login(){
        // TODO
        /*
        Add check that user has privileges to login.
         */
        User user = userService.login(username,password);
        if(user!=null){
            return "main";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Wrong credentials", ""));
        return null;
    }
}
