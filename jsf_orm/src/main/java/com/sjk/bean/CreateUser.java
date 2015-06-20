package com.sjk.bean;

import com.sjk.model.Organization;
import com.sjk.model.User;
import com.sjk.services.OrganizationService;
import com.sjk.services.UserService;
import com.sjk.utils.HibernateUtils;
import com.sjk.utils.PasswordUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 2015-06-02.
 */
@ManagedBean
@ViewScoped
public class CreateUser implements Serializable {

    private User newUser;

    private PasswordUtils password;

    private UserService userService;

    private List<Organization> organizations;

    private OrganizationService organizationService;

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
        organizationService = new OrganizationService();
        organizations = organizationService.getAllOrganizations();
    }

    public void create(){
        System.out.println("Method Create User");
        if(checkLogin()) {
            if (password.validatePassword()) {
                System.out.println("Pass validated");
                newUser.setPassword(password.getPassword());
                userService.createUser(newUser);
                System.out.println("User created");
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password is wrong.",
                        "Check pattern"));
            }
        }
        else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login exists in System.",
                    ""));
        }

    }

    public boolean checkLogin(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Query queryUserByLogin = session.getNamedQuery("User.findByLogin");
        queryUserByLogin.setParameter("login", newUser.getLogin());
        List<User> users = queryUserByLogin.list();
        if(users!=null && users.size()>0){
            return false;
        }
        return true;

    }

    public List<Organization> getOrganizations() {
        return null==organizations?new ArrayList<Organization>():organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }
}
