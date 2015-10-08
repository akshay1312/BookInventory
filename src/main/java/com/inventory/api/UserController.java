package com.inventory.api;

import com.inventory.entity.Book;
import com.inventory.entity.User;
import com.inventory.logic.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.bind.ValidationException;

/**
 * TODO: Add class level comments.
 * <br>
 * User: akshaypitale
 * Date: 10/5/15
 * Time: 4:09 PM
 */

@Controller
@RequestMapping("/")
public class UserController
{
    @Autowired
    UserManager userManager;

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public User add(@RequestBody UserAddRequest userAddRequest) throws ValidationException
    {
        return userManager.add(userAddRequest.getFirstName(), userAddRequest.getLastName());
    }


    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public User getDrawingDetailResponse(@PathVariable("userId") long userId)
    {
        return userManager.getUserDetails(userId);
    }

}
