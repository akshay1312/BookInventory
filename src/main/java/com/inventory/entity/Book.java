package com.inventory.entity;

import javax.persistence.*;

/**
 * Class that represent book table
 * <br>
 * User: akshaypitale
 * Date: 10/5/15
 * Time: 12:44 PM
 */

@Entity
@Table(name = "book")
public class Book
{
    @Id
    @Column(name = "id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="barcode", columnDefinition="VARCHAR(30)", nullable=false)
    private String barcode;

    @Column(name="title", columnDefinition="VARCHAR(30)", nullable=true)
    private String title;

    @Column(name="author", columnDefinition="VARCHAR(30)", nullable=true)
    private String author;

    @Column(name="pages", columnDefinition="INT", nullable=true)
    private Integer pages;

    @Column(name="has_read", columnDefinition="BIT", nullable=true)
    private Boolean hasRead;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Book() {
    }

    public Book(String barcode, String title, String author, Integer pages, Boolean hasRead, User user) {
        this.barcode = barcode;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Boolean getHasRead() {
        return hasRead;
    }

    public void setHasRead(Boolean hasRead) {
        this.hasRead = hasRead;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (!getId().equals(book.getId())) return false;
        if (!getBarcode().equals(book.getBarcode())) return false;
        if (getTitle() != null ? !getTitle().equals(book.getTitle()) : book.getTitle() != null) return false;
        if (getAuthor() != null ? !getAuthor().equals(book.getAuthor()) : book.getAuthor() != null) return false;
        if (getPages() != null ? !getPages().equals(book.getPages()) : book.getPages() != null) return false;
        return !(getHasRead() != null ? !getHasRead().equals(book.getHasRead()) : book.getHasRead() != null);

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getBarcode().hashCode();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getPages() != null ? getPages().hashCode() : 0);
        result = 31 * result + (getHasRead() != null ? getHasRead().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", barcode='" + barcode + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", hasRead=" + hasRead +
                ", user=" + user +
                '}';
    }
}
