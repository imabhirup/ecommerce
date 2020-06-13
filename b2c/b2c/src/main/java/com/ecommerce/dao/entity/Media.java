package com.ecommerce.dao.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Media {
    @Id
    private String id;
    private Blob picture;
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
