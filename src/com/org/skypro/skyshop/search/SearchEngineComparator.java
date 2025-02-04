package com.org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchEngineComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable searchable1, Searchable searchable2) {
        var result = Integer.compare(searchable1.searchTherm().length(), searchable2.searchTherm().length());
        return result;
    }
}
