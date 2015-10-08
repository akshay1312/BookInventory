package com.inventory.dao;

import com.inventory.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * TODO: Add class level comments.
 * <br>
 * User: akshaypitale
 * Date: 10/7/15
 * Time: 10:10 PM
 */

@Component
public class BookDao
{
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Book findById(long userId)
    {
        return em.find(Book.class, userId);
    }

    @Transactional
    public void persist(Book book)
    {
        em.persist(book);
    }
}
