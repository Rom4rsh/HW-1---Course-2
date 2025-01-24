// SkyPro
// Аршинов Роман,rom4rsh@gmail.com, 2024
// Домашнее задание по теме "Введение в ООП. Инкапсуляция"

package com.org.skypro.skyshop.product;

import com.org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    protected String title;
    protected int price;

    public Product(String name, int price) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Введите название продукта");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}

