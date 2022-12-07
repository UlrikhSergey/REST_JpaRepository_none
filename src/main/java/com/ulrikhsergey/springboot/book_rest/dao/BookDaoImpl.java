package com.ulrikhsergey.springboot.book_rest.dao;



import com.ulrikhsergey.springboot.book_rest.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Book> getAllBooks() {

        Query query = entityManager.createQuery("from Book");
        List<Book> allBooks = query.getResultList();

        return allBooks;
    }

    @Override
    public Book getBook(int id) {

        Book book = entityManager.find(Book.class,id);

        return book;

    }

    @Override
    public void saveBook(Book book) {
        Book newBook = entityManager.merge(book);
        book.setId(newBook.getId());
    }

    @Override
    public void deleteBook(int id) {
        Query query = entityManager.createQuery("delete from Book where id =:bookId");
        query.setParameter("bookId",id);
        query.executeUpdate();
    }
}
