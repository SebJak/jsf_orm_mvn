package com.sjk.model;

import com.sjk.model.embedded.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sebastian on 2015-06-16.
 */
@Entity
@Table(name="PRODUCT")
@NamedQueries({
        @NamedQuery(name = "Product.findByCode",
            query="from Product p where p.code = :code")
})
public class Product extends BaseEntity implements Serializable {

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date expirationDate;

    @ManyToOne(targetEntity=Organization.class)
    private Organization supplier;

    @Column(precision=10, scale=2)
    private double price;

    @Column(length = 64)
    private String description;

    @ManyToOne(cascade=CascadeType.ALL, targetEntity = Warehouse.class)
    @JoinTable(name="WAREHOUSE_PRODUCT",
            joinColumns={@JoinColumn(name="productId", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="warehouseId", referencedColumnName="id")})
    private Warehouse warehouse;

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
        if( !super.equals(o)) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        return !(code != null ? !code.equals(product.code) : product.code != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + expirationDate.hashCode();
        return result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
