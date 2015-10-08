package com.inventory.entity;


import javax.persistence.*;
import java.util.List;

/**
 * Class that represent user table
 * <br>
 * User: akshaypitale
 * Date: 10/5/15
 * Time: 12:44 PM
 */

@Entity
@Table(name = "user")
public class User
{
    @Id
    @Column(name = "id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="first_name", columnDefinition="VARCHAR(25)", nullable=false)
    private String firstName;

    @Column(name="last_name", columnDefinition="VARCHAR(30)", nullable=true)
    private String lastName;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Book> books;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!getId().equals(user.getId())) return false;
        if (!getFirstName().equals(user.getFirstName())) return false;
        return !(getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null);

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }
}
