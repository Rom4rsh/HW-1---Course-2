// SkyPro
// Аршинов Роман,rom4rsh@gmail.com, 2024
// Домашнее задание по теме "Введение в ООП. Инкапсуляция"

package com.org.skypro.skyshop.product;

public abstract class Product implements Searchable {
    protected String title;
    protected int price;

    public Product(String name, int price) {
        this.title = name;
        this.price = price;
    }

    protected Product() {
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + ": " + price;
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String searchTherm() {
        return "Имя товара " + title;
    }

    @Override
    public String searchContent() {
        return "Product";
    }


}

