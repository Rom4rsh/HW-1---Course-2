// SkyPro
// Аршинов Роман,rom4rsh@gmail.com, 2024
// Домашнее задание по теме "Введение в ООП. Инкапсуляция"

package com.org.skypro.skyshop.basket;

import com.org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private final Map<String, List<Product>> products;

    public ProductBasket() {
        products = new TreeMap<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }

        List<Product> item = products.computeIfAbsent(product.getTitle(), k -> new LinkedList<>());
        item.add(product);
    }


    public int getTotalPrice() {
        return products.values()
                .stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice).sum();
    }

    public void printProducts() {

        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
        } else {
            products.values()
                    .stream()
                    .flatMap(Collection::stream)
                    .forEach(System.out::println);
            System.out.println("Количество специальных товаров = " + getSpecialCount());
        }
    }

    public boolean findProduct(String title) {
        return products.containsKey(title);
    }

    public void emptyBasket() {
        products.clear();
    }


    public List<Product> deleteByName(String title) {
        List<Product> delProd = new LinkedList<>();


        // Проверка на пустое или null название
        if (title == null || title.trim().isEmpty()) {
            return delProd;
        }

        Iterator<Map.Entry<String, List<Product>>> entryIterator = products.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, List<Product>> mapEntry = entryIterator.next();
            List<Product> productList = mapEntry.getValue();

            // Используем removeIf для удаления продуктов с указанным названием
            boolean removed = productList.removeIf(product -> {
                boolean toRemove = product.getTitle().equals(title);
                if (toRemove) {
                    delProd.add(product); // Добавляем в список удалённых продуктов
                }
                return toRemove;
            });

            // Если список после удаления стал пустым, удаляем запись из Map
            if (productList.isEmpty()) {
                entryIterator.remove();
            }
        }

        return delProd;
    }

    public int getSpecialCount() {
        return (int) products.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }
}









