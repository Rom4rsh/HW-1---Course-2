package com.org.skypro.skyshop.search;

import com.org.skypro.skyshop.product.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class SearchEngine {

    private final List<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new ArrayList<>();
    }

    public void searchAdd(Searchable item) {
        searchableItems.add(item);
    }

    // Метод для поиска по строке query
    public Map<String,Searchable> search(String query) {
        Map<String,Searchable> results = new TreeMap<>();
        //int resultCount = 0;
        for (Searchable item : searchableItems) {
            if (item == null) {
                continue;
            }
            if (item.searchTherm().contains(query)) {
                results.put(item.searchTherm(), item);
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













