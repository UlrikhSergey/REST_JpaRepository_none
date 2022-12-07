package com.ulrikhsergey.springboot.book_rest.dao;




import com.ulrikhsergey.springboot.book_rest.entity.Book;

import java.util.List;

public interface BookDao {
    public List<Book> getAllBooks();

    public void saveBook(Book book);

    public void deleteBook(int id);

    public Book getBook(int id);


}
