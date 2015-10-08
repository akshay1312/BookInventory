package com.inventory.api;

/**
 * TODO: Add class level comments.
 * <br>
 * User: akshaypitale
 * Date: 10/7/15
 * Time: 10:06 PM
 */
public class BookAddRequest
{
    private String title;

    private String author;

    private int pages;

    private Long userId;

    public BookAddRequest() {
    }

    public BookAddRequest(String title, String author, int pages, Long userId) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
