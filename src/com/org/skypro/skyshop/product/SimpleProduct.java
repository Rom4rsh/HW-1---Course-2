package com.org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    public SimpleProduct(String name, int price) {

        super(name, price);
        if (price < 1) {
            throw new IllegalArgumentException("Цена продукта указана не верно");
        }
    }

    @Override
    public int getPrice() {
        return price;
    }

//    @Override
//    public int compareTo(Product other) {
//        return super.compareTo(other);
   // }

}

