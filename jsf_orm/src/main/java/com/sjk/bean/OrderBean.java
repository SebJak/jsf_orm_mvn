package com.sjk.bean;

import com.sjk.model.Order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Sebastian on 2015-06-17.
 */
@ManagedBean
@SessionScoped
public class OrderBean {

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void create(){
        //TODO complete this method

    }
}
