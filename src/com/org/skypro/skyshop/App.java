// SkyPro
// Аршинов Роман,rom4rsh@gmail.com, 2024
// Домашнее задание по теме "Введение в ООП. Инкапсуляция"

package com.org.skypro.skyshop;

import com.org.skypro.skyshop.article.Article;
import com.org.skypro.skyshop.basket.ProductBasket;
import com.org.skypro.skyshop.product.*;
import com.org.skypro.skyshop.search.SearchEngine;

import java.util.List;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        var product1 = new SimpleProduct("Кофта", 1000);
        var product2 = new SimpleProduct("Кеды", 2000);
        var product3 = new SimpleProduct("Футболка", 2000);
        var product4 = new SimpleProduct("Рубашка", 2000);
        var prodcut5 = new SimpleProduct("Джинсы", 3000);
        var product7 = new FixPriceProduct("Очки");


        try {
            // Добавление продукта в корзину.
            basket.addProduct(product1);
            basket.addProduct(product2);
            basket.addProduct(product3);
            basket.addProduct(product4);
            basket.addProduct(prodcut5);
            basket.addProduct(product7);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        // Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.addProduct(new SimpleProduct("Сумка", 4000));

        // Печать содержимого корзины с несколькими товарами.
        basket.printProducts();

        // Удаление продукта по имени
        List<Product> delProd = basket.deleteByName("Футболка");
        System.out.print("delProd : ");
        for (Product product : delProd) {
            System.out.println(product);
        }
        if (delProd.isEmpty()) {
            System.out.println("Список пуст");
        }


        //  Удаление несуществующего продукта по имени
        delProd = basket.deleteByName("ФКК");
        System.out.print("delProd : ");
        for (Product product : delProd) {
            System.out.println(product);
        }
        if (delProd.isEmpty()) {
            System.out.println("Список пуст");
        }

        basket.printProducts();

        // Получение стоимости корзины с несколькими товарами.
        int totalPrice = basket.getTotalPrice();
        System.out.println("Цена корзины равна " + totalPrice);

        // Поиск товара, который есть в корзине.
        boolean itemExists = basket.findProduct("Майка");
        System.out.println("Наличие товара в корзине: " + itemExists);

        // Поиск товара, которого нет в корзине.
        itemExists = basket.findProduct("Пижама");
        System.out.println("Наличие товара в корзине: " + itemExists);

        // Очистка корзины.
        basket.emptyBasket();

        // Печать содержимого пустой корзины.
        basket.printProducts();

        // Получение стоимости пустой корзины.
        totalPrice = basket.getTotalPrice();
        System.out.println("Цена корзины равна " + totalPrice);

        // Поиск товара по имени в пустой корзине
        itemExists = basket.findProduct("Футболка");
        System.out.println("Наличие товара в корзине: " + itemExists);


        SearchEngine searchEngine = new SearchEngine();

        searchEngine.searchAdd(product1);
        searchEngine.searchAdd(product2);
        searchEngine.searchAdd(product3);
        searchEngine.searchAdd(product4);
        searchEngine.searchAdd(prodcut5);
        searchEngine.searchAdd(product7);


        Article article1 = new Article("31 декабря", "Празднование нового года");
        Article article2 = new Article("8 марта", "Женский день");
        Article article3 = new Article("23 февраля", "Мужской день");
        Article article4 = new Article("4 ноября", "День народного единства");

        searchEngine.searchAdd(article1);
        searchEngine.searchAdd(article2);
        searchEngine.searchAdd(article3);
        searchEngine.searchAdd(article4);


        var searchResults = searchEngine.search("31");
        System.out.println(searchResults);

        var searchResults2 = searchEngine.search("Мужской день");
        System.out.println(searchResults2);


        try {
            Product product = new SimpleProduct("", 1000);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }

        try {
            Product simpleProduct = new SimpleProduct("Яблоко", 0);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }

        try {
            Product discountProduct = new DiscountProduct("Телевизор", 10000, 100);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }

        try {
            var searchBest = searchEngine.findBestMatch("d");
            System.out.println(searchBest);
        } catch (BestResultNotFound e) {
            System.err.println(e);
        }
    }
}

