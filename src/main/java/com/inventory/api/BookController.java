package com.inventory.api;

import com.inventory.entity.Book;
import com.inventory.logic.BookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

/**
 * TODO: Add class level comments.
 * <br>
 * User: akshaypitale
 * Date: 10/5/15
 * Time: 4:10 PM
 */

@Controller
@RequestMapping("/")
public class BookController
{
    @Autowired
    BookManager bookManager;

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public Book add(@RequestBody BookAddRequest bookAddRequest) throws ValidationException
    {
        return bookManager.add(bookAddRequest.getTitle(), bookAddRequest.getAuthor(),
                bookAddRequest.getPages(), bookAddRequest.getUserId());
    }

    @RequestMapping(value = "/book/{bookId}/return", method = RequestMethod.PUT)
    public Book bookReturn(@PathVariable("bookId") Long bookId, @RequestParam Boolean hasRead) throws Exception
    {
        return bookManager.update(bookId, hasRead);
    }
}
