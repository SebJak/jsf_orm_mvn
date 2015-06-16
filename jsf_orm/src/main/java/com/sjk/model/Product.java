package com.sjk.model;

import com.sjk.model.embedded.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sebastian on 2015-06-16.
 */
@Entity
@Table(name="PRODUCT")
public class Product extends BaseEntity implements Serializable {

    private String code;

    private String name;

    private Date expirationDate;

    @ManyToOne(targetEntity=Organization.class)
    private Organization supplier;

    private double price;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Organization getSupplier() {
        return supplier;
    }

    public void setSupplier(Organization supplier) {
        this.supplier = supplier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        return !(code != null ? !code.equals(product.code) : product.code != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", expirationDate=" + expirationDate +
                ", supplier=" + supplier +
                ", price=" + price +
                '}';
    }
}
