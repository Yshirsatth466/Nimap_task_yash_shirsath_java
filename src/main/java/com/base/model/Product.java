package com.base.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    private String pname;

    private double price;

    private int quantity; 

    @ManyToOne
    private Category category;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() { // Getter for price
        return price;
    }

    public void setPrice(double price) { // Setter for price
        this.price = price;
    }

    public int getQuantity() { // Getter for quantity
        return quantity;
    }

    public void setQuantity(int quantity) { // Setter for quantity
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
