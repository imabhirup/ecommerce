package com.ecommerce.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Catalog {
    @Id
    private String id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    private Store store;
    @OneToMany(mappedBy = "catalog")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
