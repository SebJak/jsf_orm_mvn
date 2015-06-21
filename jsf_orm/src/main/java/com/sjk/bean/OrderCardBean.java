package com.sjk.bean;

import com.sjk.model.OrderCard;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by Sebastian on 2015-06-16.
 */
@ManagedBean
@SessionScoped
public class OrderCardBean implements Serializable {

    private OrderCard orderCard;

    public OrderCard getOrderCard() {
        return orderCard;
    }

    public void setOrderCard(OrderCard orderCard) {
        this.orderCard = orderCard;
    }

    public void create(){
        //TODO complete this method
    }
}
