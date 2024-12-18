package com.org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    public SimpleProduct(String name, int price) {
        super(name, price);
    }

    @Override
    public int getPrice() {
        return price;
    }
}

