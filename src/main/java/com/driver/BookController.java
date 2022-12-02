package com.driver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

    private List<Book> bookList;

    private static int id;


    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookController(){
        id++;
        this.bookList = new ArrayList<Book>();

    }
    @Autowired
    BookService bookService;
    // post request /create-book
    // pass book as request body
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        // Your code goes here.
        return new ResponseEntity(bookService.addBook(book), HttpStatus.CREATED);
    }

    // get request /get-book-by-id/{id}
    // pass id as path variable
    // getBookById()
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id){
        return new ResponseEntity(bookService.getBookById(Integer.parseInt(id)),HttpStatus.ACCEPTED);
    }

    // delete request /delete-book-by-id/{id}
    // pass id as path variable
    // deleteBookById()
    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable String id){
        return new ResponseEntity(bookService.deleteBookByIdFromDB(Integer.parseInt(id)),HttpStatus.OK);
    }

    // get request /get-all-books
    // getAllBooks()
    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity(bookService.getAllBooksFromDB(),HttpStatus.ACCEPTED);
    }

    // delete request /delete-all-books
    // deleteAllBooks()
    @DeleteMapping("/delete-all-books")
    public ResponseEntity<String> deleteAllBooks(){
        return new ResponseEntity(bookService.deleteAllBooksFromDB(),HttpStatus.OK);
    }

    // get request /get-books-by-author
    // pass author name as request param
    // getBooksByAuthor()
    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<String>> getBooksByAuthor(@RequestParam("authorName") String authorName){
        return new ResponseEntity(bookService.getBooksByAuthorFromDB(authorName),HttpStatus.ACCEPTED);
    }

    // get request /get-books-by-genre
    // pass genre name as request param
    // getBooksByGenre()

    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<String>> getBooksByGenre(@RequestParam("genreName") String genreName){
        return new ResponseEntity(bookService.getBooksByGenreFromDB(genreName),HttpStatus.ACCEPTED);
    }

}
