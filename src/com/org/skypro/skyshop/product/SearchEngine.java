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

    public Searchable findBestMatch(String search) throws BestResultNotFound {

        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : searchableItems) {
            if (item == null) {
                continue;
            }
            String searchTerm = item.searchTherm();
            int count = (countOcurrreneces(searchTerm, search));
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }if (bestMatch==null){
            throw new BestResultNotFound("Ничего не найдено по запросу - "+ search);
        }
        return bestMatch;
    }

    public int countOcurrreneces(String searchTerm, String search) {
        int count = 0;
        int index = 0;
        int subString = searchTerm.indexOf(search, index);


        while (subString != -1) {
            count++;
            index = index + search.length();
            subString = searchTerm.indexOf(search, index);
        }
        return count;
    }
}













