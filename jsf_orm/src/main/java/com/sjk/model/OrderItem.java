package com.sjk.model;

import com.sjk.model.embedded.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sebastian on 2015-06-16.
 */
@Entity
@Table(name="ORDER_ITEM")
public class OrderItem extends BaseEntity implements Serializable {

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "productId")
    private Product product;

    @Column(nullable = false, precision=10, scale=2)
    private double amount;

    @Column(nullable = false)
    private String orderUnit;

    @ManyToOne(targetEntity = OrderCard.class)
    @JoinColumn(name = "orderCardId")
    private OrderCard orderCard;

    public OrderCard getOrderCard() {
        return orderCard;
    }

    public void setOrderCard(OrderCard orderCard) {
        this.orderCard = orderCard;
    }

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

        OrderItem orderItem = (OrderItem) o;

        if (Double.compare(orderItem.amount, amount) != 0) return false;
        if (!product.equals(orderItem.product)) return false;
        return orderUnit.equals(orderItem.orderUnit);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        //result = 31 * result + product.hashCode();
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + orderUnit.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product +
                ", amount=" + amount +
                ", orderUnit='" + orderUnit + '\'' +
                '}';
    }


}
