// SkyPro
// Аршинов Роман,rom4rsh@gmail.com, 2024
// Домашнее задание по теме "Введение в ООП. Инкапсуляция"

package com.org.skypro.skyshop;

import com.org.skypro.skyshop.basket.ProductBasket;
import com.org.skypro.skyshop.product.DiscountProduct;
import com.org.skypro.skyshop.product.FixPriceProduct;
import com.org.skypro.skyshop.product.Product;
import com.org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        // Добавление продукта в корзину.
        basket.addProduct(new SimpleProduct("Майка", 1000));
        basket.addProduct(new SimpleProduct("Кеды", 1500));
        basket.addProduct(new SimpleProduct("Футболка", 2000));
        basket.addProduct(new SimpleProduct("Рубашка", 2000));
        basket.addProduct(new SimpleProduct("Джинсы", 3000));
        basket.addProduct(new DiscountProduct("Толстовка",1000,10));
        basket.addProduct(new FixPriceProduct("Очки"));


        // Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.addProduct(new SimpleProduct("Сумка", 4000));

        // Печать содержимого корзины с несколькими товарами.
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

        Product product2 = new FixPriceProduct("bb");
        System.out.println(product2.isSpecial());
    }
}
