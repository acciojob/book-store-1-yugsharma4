package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.addBookToDB(book);
    }

    public Book getBookById(int bookId){
        return bookRepository.getBookByIdFromDB(bookId);
    }

    public List<Book> getAllBooksFromDB(){
        return bookRepository.getAllBooksFromDB();
    }

    public String deleteAllBooksFromDB(){
        return bookRepository.deleteAllBooksFromDB();
    }

    public String deleteBookByIdFromDB(int id){
        return bookRepository.deleteBookByIdFromDB(id);
    }

    public List<String> getBooksByAuthorFromDB(String authorName){
        return bookRepository.getBooksByAuthorFromDB(authorName);
    }

    public List<String> getBooksByGenreFromDB(String genreName){
        return bookRepository.getBooksByGenreFromDB(genreName);
    }

}
