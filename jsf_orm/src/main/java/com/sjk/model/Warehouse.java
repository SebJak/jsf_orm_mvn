package com.sjk.model;

import com.sjk.model.embedded.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Sebastian on 2015-06-16.
 */
@Entity
@Table(name="WAREHOUSE")
public class Warehouse extends BaseEntity implements Serializable {

    @OneToOne(targetEntity = Organization.class)
    private Organization organization;

    @OneToOne(targetEntity = Product.class)
    private Product products;

    private long amount;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Warehouse warehouse = (Warehouse) o;

        if (!organization.equals(warehouse.organization)) return false;
        if (!products.equals(warehouse.products)) return false;
        return name.equals(warehouse.name);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + organization.hashCode();
        result = 31 * result + products.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "organization=" + organization +
                ", products=" + products +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                '}';
    }
}
