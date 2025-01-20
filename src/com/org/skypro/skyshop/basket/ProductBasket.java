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

        List<Product> item;

        if (!products.containsKey(product.getTitle())) {
            item = new LinkedList<>();
            products.put(product.getTitle(), item);
        } else {
            item = products.get(product.getTitle());
        }
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


    public List<Product> delByName(String title) {
        List<Product> delProd = new LinkedList<>();

        if (title == null) {
            System.out.println("Введите название");
            return delProd;
        }

        Iterator<Map.Entry<String, List<Product>>> entryIterator = products.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, List<Product>> mapEntry = entryIterator.next();
            List<Product> productList = mapEntry.getValue();

            // Итерируемся по списку и удаляем продукты с указанным названием
            Iterator<Product> productIterator = productList.iterator();
            while (productIterator.hasNext()) {
                Product product = productIterator.next();
                if (product.getTitle().equals(title)) {
                    delProd.add(product);
                    productIterator.remove(); // Удаляем продукт из списка
                }
            }

            // Если список после удаления стал пустым, удаляем запись из Map
            if (productList.isEmpty()) {
                entryIterator.remove();
            }
        }
        return delProd;
    }
}









