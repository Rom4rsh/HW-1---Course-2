package com.org.skypro.skyshop.search;

import com.org.skypro.skyshop.product.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class SearchEngine {

    private final HashSet<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new HashSet<>();
    }

    public void searchAdd(Searchable item) {
        searchableItems.add(item);
    }

    // Метод для поиска по строке query
    public Set<Searchable> search(String query) {
        return searchableItems.stream()
                .filter(item -> item != null && item.searchTherm().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchEngineComparator())));
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {

        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : searchableItems) {
            if (item == null) {
                continue;
            }
            String searchTerm = item.searchTherm();
            int count = (countOcurreneces(searchTerm, search));
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Ничего не найдено по запросу - " + search);
        }
        return bestMatch;
    }

    public int countOcurreneces(String searchTerm, String search) {
        // Проверка на null
        if (searchTerm == null || search == null) {
            throw new IllegalArgumentException("введите значение search или searchTherm");
        }

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













