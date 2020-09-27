package com.example.lesson1android3;

import android.widget.ImageView;

public class Book {
    private String title;
    private String description;
    private ImageView imageBook;

    public Book(String title,String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageView getImageBook() {
        return imageBook;
    }

    public void setImageBook(ImageView imageBook) {
        this.imageBook = imageBook;
    }
}
