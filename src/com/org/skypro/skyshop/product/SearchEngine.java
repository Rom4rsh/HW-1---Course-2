package com.org.skypro.skyshop.product;

import java.util.Arrays;

public class SearchEngine {
    private static final int MAX_RESULTS = 5;
    private Searchable[] searchableItems;


    public SearchEngine(int size) {
        this.searchableItems = new Searchable[size];
        Arrays.fill(searchableItems, null);
    }

    private int currentIndex = 0;

    public void searchAdd(Searchable item) {
        searchableItems[currentIndex++] = item;
        if (currentIndex >= searchableItems.length) {
            System.out.println("Невозможно добавить элемент для поиска");
        }
    }

    // Метод для поиска по строке query и возвращения 5 результатов
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[MAX_RESULTS];
        int resultCount = 0;
        for (var item : searchableItems) {
            if (item == null) {
                continue;
            }
            if (item.searchTherm().contains(query)) {
                results[resultCount++] = item;
                if (resultCount >= results.length) {
                    break;
                }
            }
        }
        return results;
    }
}











