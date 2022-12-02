package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BookRepository {
    List<Book> books = new ArrayList<>();


    //Create a new Book
    public Book addBookToDB(Book book){
        books.add(book);
        return book;
    }

    //get a book
    public Book getBookByIdFromDB(int bookId){
        if(!books.isEmpty()){
            for(Book book : books){
                if(book.getId() == bookId) return book;
            }
        }

        return null;
    }

    public List<Book> getAllBooksFromDB(){
        return books;
    }

    public String deleteAllBooksFromDB(){
        books.clear();
        return "All books have been deleted!!";
    }

    public String deleteBookByIdFromDB(int bookId){
        if(!books.isEmpty()){
            for(Book book: books){
                if(book.getId() == bookId) {
                    books.remove(book);
                    return "Book has been deleted!!!";
                }
            }
        }

        return "Book does not found!!!";
    }

    public List<String> getBooksByAuthorFromDB(String authorName){
        List<String> authBooks = new ArrayList<>();
        if(!books.isEmpty()){
            for(Book book: books){
                if(book.getAuthor().equals(authorName)){
                    authBooks.add(book.getName());
                }
            }
        }

        return authBooks;
    }


    public List<String> getBooksByGenreFromDB(String genreName){
        List<String> genBooks = new ArrayList<>();
        if(!books.isEmpty()){
            for(Book book: books){
                if(book.getGenre().equals(genreName)){
                    genBooks.add(book.getName());
                }
            }
        }

        return genBooks;
    }

}
