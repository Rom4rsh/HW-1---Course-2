package com.org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchEngineComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable searchable1, Searchable searchable2) {
        int result = Integer.compare(searchable1.searchTherm().length(), searchable2.searchTherm().length());
//        if (result == 0) {
//            searchable1.searchTherm().compareTo(searchable2.searchTherm());
//        }
        return result;
    }
}
