package com.org.skypro.skyshop;
// SkyPro
// Аршинов Роман,rom4rsh@gmail.com, 2024
// Домашнее задание по теме "Введение в ООП. Инкапсуляция"

import com.org.skypro.skyshop.basket.ProductBasket;
import com.org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Майка", 1000);
        Product product2 = new Product("Кеды", 1500);
        Product product3 = new Product("Футболка", 2000);
        Product product4 = new Product("Джинсы", 3000);
        Product product5 = new Product("Рубашка", 4000);

        Product product6 = new Product("Кофта", 5000);

        ProductBasket basket = new ProductBasket();

        // Добавление продукта в корзину.
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        // Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.addProduct(product6);

        // Печать содержимого корзины с несколькими товарами.
        basket.printProducts();

        // Получение стоимости корзины с несколькими товарами.
        int totalPrice = basket.getTotalPrice();
        System.out.println("Цена корзины равна " + totalPrice);

        // Поиск товара, который есть в корзине.
        boolean itemExists = basket.findProduct(product1.getTitle());
        System.out.println("Наличие товара в корзине: " + itemExists);

        // Поиск товара, которого нет в корзине.
        itemExists = basket.findProduct(product6.getTitle());
        System.out.println("Наличие товара в корзине: " + itemExists);

        // Очистка корзины.
        basket.emptyBasket();

        // Печать содержимого пустой корзины.
        basket.printProducts();

        // Получение стоимости пустой корзины.
        totalPrice = basket.getTotalPrice();
        System.out.println("Цена корзины равна " + totalPrice);

        // Поиск товара по имени в пустой корзине
        itemExists = basket.findProduct(product1.getTitle());
        System.out.println("Наличие товара в корзине: " + itemExists);
    }
}
