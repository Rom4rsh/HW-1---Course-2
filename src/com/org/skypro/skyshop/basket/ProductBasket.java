// SkyPro
// Аршинов Роман,rom4rsh@gmail.com, 2024
// Домашнее задание по теме "Введение в ООП. Инкапсуляция"

package com.org.skypro.skyshop.basket;

import com.org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {

    private final Product[] products;

    public final int STORAGE_MAX = 20;

    public ProductBasket() {
        products = new Product[STORAGE_MAX];
    }

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
    }

    public int getTotalPrice() {
        int sum = 0;
        for (var product : products) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public void printProducts() {
        boolean empty = true;
        int specialCount = 0;
        for (var product : products) {
            if (product != null) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
                empty = false;
            }
        }
        if (!empty) {
            System.out.println("Колличество специальных товаров " + specialCount);
        }

        if (empty) {
            System.out.println("в корзине пусто");
        }
    }

    public boolean findProduct(String title) {
        for (var product : products) {
            if (product != null) {
                if (product.getTitle().equals(title)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void emptyBasket() {
        Arrays.fill(products, null);
    }
}


