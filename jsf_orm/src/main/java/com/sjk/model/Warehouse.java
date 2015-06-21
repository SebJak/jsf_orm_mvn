package com.sjk.model;

import com.sjk.model.embedded.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sebastian on 2015-06-16.
 */
@Entity
@Table(name="WAREHOUSE")
public class Warehouse extends BaseEntity implements Serializable {

    @OneToOne(targetEntity = Organization.class)
    private Organization organization;

    @OneToMany(cascade=CascadeType.ALL, targetEntity = Product.class)
    @JoinTable(name="WAREHOUSE_PRODUCT",
            joinColumns={@JoinColumn(name="warehouseId", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="productID", referencedColumnName="id")})
    private List<Product> products;

    @Column(columnDefinition="Decimal(10,2) default '0.00'")
    private long amount;

    @Column(nullable = false, length = 64)
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
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
