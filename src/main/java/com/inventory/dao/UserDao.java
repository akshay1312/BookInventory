package com.inventory.dao;

import com.inventory.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * TODO: Add class level comments.
 * <br>
 * User: akshaypitale
 * Date: 10/6/15
 * Time: 11:40 PM
 */

@Component
public class UserDao
{
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public User findById(long userId)
    {
        return em.find(User.class, userId);
    }

    @Transactional
    public void persist(User user)
    {
        em.persist(user);
    }

}
