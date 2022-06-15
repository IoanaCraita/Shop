package com.ioana;

import java.util.List;
import java.util.Map;

public class Cart {
    private int quantity;
    private int total;
  //  private List<Product> products;
    private Map<Product,Integer> products;

    public Map<Product, Integer> getProducts() {
        return products;
    }
    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
