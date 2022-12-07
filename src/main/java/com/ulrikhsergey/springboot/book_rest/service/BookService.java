package com.ulrikhsergey.springboot.book_rest.service;




import com.ulrikhsergey.springboot.book_rest.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAllBooks();

    public void saveBook(Book book);

    public void deleteBook(int id);

    public Book getBook(int id);
}
