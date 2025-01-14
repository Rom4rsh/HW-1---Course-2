package com.org.skypro.skyshop.search;

import com.org.skypro.skyshop.product.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public final class SearchEngine {

    private final List<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new ArrayList<>();
    }

    public void searchAdd(Searchable item) {
        searchableItems.add(item);
    }

    // Метод для поиска по строке query
    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        int resultCount = 0;
        for (var item : searchableItems) {
            if (item == null) {
                continue;
            }
            if (item.searchTherm().contains(query)) {
                results.add(resultCount, item);
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
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Ничего не найдено по запросу - " + search);
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













