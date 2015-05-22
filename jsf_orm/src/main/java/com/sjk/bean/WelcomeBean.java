package com.sjk.bean;

import com.sjk.utils.HibernateUtils;
import org.hibernate.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by Sebastian on 2015-05-18.
 */
@ManagedBean
@SessionScoped
public class WelcomeBean  implements Serializable{

    private String sayHello;

    public String getSayHello() {
        return sayHello;
    }

    public void setSayHello(String sayHello) {
        this.sayHello = sayHello;
    }

    public void testAction(){
        Session session = HibernateUtils.getSessionFactory().openSession();
    }
}
