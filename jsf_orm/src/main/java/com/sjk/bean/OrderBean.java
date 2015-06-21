package com.sjk.bean;

import com.sjk.model.OrderItem;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by Sebastian on 2015-06-17.
 */
@ManagedBean
@SessionScoped
public class OrderBean implements Serializable {

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
