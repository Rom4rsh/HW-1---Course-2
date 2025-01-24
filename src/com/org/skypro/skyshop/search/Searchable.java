package com.org.skypro.skyshop.search;

public interface Searchable {

    String searchTherm();

    String searchContent();


    default String searchable() {
        return "имя " + searchTherm() + " объекта " + "тип " + searchContent() + " объекта";

    }

}




