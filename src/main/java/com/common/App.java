package com.common;

import com.inventory.dao.UserDao;
import com.inventory.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO: Add class level comments.
 * <br>
 * User: akshaypitale
 * Date: 10/7/15
 * Time: 12:06 AM
 */
public class App
{
    public static void main(String[] args)
    {
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("/web/WEB-INF/applicationContext.xml");

        UserDao userDao = (UserDao)appContext.getBean("userDao");

        /** insert **/
        User user = new User("akshay", "pitale");
        userDao.persist(user);

        /** select **/
        User storedUser = userDao.findById(user.getId());
        System.out.println(storedUser);


        System.out.println("Done");
    }
}
