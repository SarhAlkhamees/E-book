package com.example.assignment2_sarh;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Book {
    private String author_name;
    private String book_title;
    private String book_cate;

    public Book() {
    }

    public Book(String author_name, String book_title, String book_cate) {
        this.author_name = author_name;
        this.book_title = book_title;
        this.book_cate = book_cate;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getBook_title() {
        return book_title;
    }

    public String getBook_cate() {
        return book_cate;
    }
}
