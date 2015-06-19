package com.sjk.bean;

import com.sjk.model.OrderItem;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Sebastian on 2015-06-17.
 */
@ManagedBean
@SessionScoped
public class OrderBean {

    private OrderItem orderItem;

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public void create(){
        //TODO complete this method

    }
}
