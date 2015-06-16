package com.sjk.model;

import com.sjk.model.embedded.BaseEntity;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Sebastian on 2015-06-16.
 */
public class OrderCard extends BaseEntity implements Serializable{

    @OneToMany(targetEntity=Order.class, mappedBy="order")
    private List<Order> orders;

    private Date orderTime;

    @ManyToOne(targetEntity=Organization.class)
    private Organization supplier;

    @ManyToOne(targetEntity=Organization.class)
    private Organization customer;

    @ManyToOne(targetEntity=Organization.class)
    private User user;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Organization getSupplier() {
        return supplier;
    }

    public void setSupplier(Organization supplier) {
        this.supplier = supplier;
    }

    public Organization getCustomer() {
        return customer;
    }

    public void setCustomer(Organization customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrderCard orderCard = (OrderCard) o;

        return user.equals(orderCard.user);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OrderCard{" +
                "orders=" + orders +
                ", orderTime=" + orderTime +
                ", supplier=" + supplier +
                ", customer=" + customer +
                ", user=" + user +
                '}';
    }
}
