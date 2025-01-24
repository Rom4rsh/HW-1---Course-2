package com.org.skypro.skyshop.article;

import com.org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public final class Article implements Searchable  {

    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Название статьи: " + title +
                " - Текст статьи: " + text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String searchTherm() {
        return "Название: " + title +
                "- Текст: " + text;
    }

    @Override
    public String searchContent() {
        return "Article";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}

