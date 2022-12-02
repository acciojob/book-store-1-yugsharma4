package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Book {

     private static int id;

     private String name;

     private String genre;
     
     private String author;

     private int newId;

     public Book(){
        this.newId = ++id;
     }

    public Book(String name, String genre, String author) {
        this.name = name;
        this.genre = genre;
        this.author = author;
    }

    public int getId() {
        return newId;
    }

    public void setId(int id) {
        this.id = newId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
