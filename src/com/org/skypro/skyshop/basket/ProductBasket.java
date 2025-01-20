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
        int sum = 0;
        for (List<Product> products : products.values()) {
            for (Product product : products) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public void printProducts() {
        boolean empty = true;
        int specialCount = 0;
        for (List<Product> products : products.values()) {
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product);
                    if (product.isSpecial()) {
                        specialCount++;
                    }
                    empty = false;
                }
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
}









