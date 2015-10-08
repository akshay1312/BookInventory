package com.inventory.logic;

import com.inventory.api.BookAddRequest;
import com.inventory.dao.BookDao;
import com.inventory.dao.UserDao;
import com.inventory.entity.Book;
import com.inventory.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.ValidationException;
import java.util.UUID;

/**
 * TODO: Add class level comments.
 * <br>
 * User: akshaypitale
 * Date: 10/7/15
 * Time: 9:26 PM
 */
@Component
public class BookManager
{
    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserDao userDao;

    @Transactional
    public Book add(String title, String author, int pages, Long userId) throws ValidationException
    {
        String barcode = UUID.randomUUID().toString(); // this generate unique barcode for each book
        if(userId == null)
            throw new ValidationException("Book has not assigned to any user");
        User user = userDao.findById(userId);
        Book  book = new Book(barcode, title, author, pages, false, user);
        bookDao.persist(book);
        return book;
    }

    @Transactional
    public Book update(long bookId, boolean hasRead) throws Exception
    {
        Book book = bookDao.findById(bookId);
        if(book == null)
            throw new Exception("Book is not available");
        book.setHasRead(hasRead);
        return book;
    }

}
