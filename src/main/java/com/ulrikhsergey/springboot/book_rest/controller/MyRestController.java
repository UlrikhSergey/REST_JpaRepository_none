package com.ulrikhsergey.springboot.book_rest.controller;



import com.ulrikhsergey.springboot.book_rest.entity.Book;
import com.ulrikhsergey.springboot.book_rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MyRestController {
    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public List<Book> showAllEmployees(Model model){

        List<Book> allBooks= bookService.getAllBooks();
        model.addAttribute("allBooks",allBooks);

        return allBooks;
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id){
        Book book = bookService.getBook(id);
        return book;
    }

    @PostMapping("/books")
    public Book addNewBook (@RequestBody Book book){
        bookService.saveBook(book);
        return book;
    }


    @PutMapping("/books")
    public Book updateBook (@RequestBody Book book){
        bookService.saveBook(book);
        return book;
    }


    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int id){
        Book book = bookService.getBook(id);
        bookService.deleteBook(id);
        return "Employee with id = " + id + " was deleted";
    }

}
