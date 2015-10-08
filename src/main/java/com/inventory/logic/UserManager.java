package com.inventory.logic;

import com.inventory.dao.UserDao;
import com.inventory.entity.Book;
import com.inventory.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationException;

/**
 * TODO: Add class level comments.
 * <br>
 * User: akshay
 * Date: 10/6/15
 * Time: 5:35 PM
 */

@Component
public class UserManager
{

    @Autowired
    private UserDao userDao;

    @Transactional
    public User getUserDetails(long userId)
    {
        User user = userDao.findById(userId);

        return user;
    }

    @Transactional
    public User add(String firstName, String lastName) throws ValidationException
    {
        if(firstName == null)
            throw new ValidationException("First name is required");
        User user = new User(firstName, lastName);
        userDao.persist(user);
        return user;
    }
}
