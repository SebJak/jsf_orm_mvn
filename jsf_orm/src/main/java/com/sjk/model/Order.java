package com.sjk.model;

import com.sjk.model.embedded.BaseEntity;

import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sebastian on 2015-06-16.
 */
public class Order extends BaseEntity implements Serializable {

    @ManyToOne(targetEntity=Product.class)
    private Product product;

    private double amount;

    private String orderUnit;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOrderUnit() {
        return orderUnit;
    }

    public void setOrderUnit(String orderUnit) {
        this.orderUnit = orderUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Order order = (Order) o;

        if (Double.compare(order.amount, amount) != 0) return false;
        if (!product.equals(order.product)) return false;
        return orderUnit.equals(order.orderUnit);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + product.hashCode();
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + orderUnit.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product=" + product +
                ", amount=" + amount +
                ", orderUnit='" + orderUnit + '\'' +
                '}';
    }


}
