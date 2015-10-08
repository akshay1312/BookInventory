package com.inventory.api;

/**
 * TODO: Add class level comments.
 * <br>
 * User: akshaypitale
 * Date: 10/7/15
 * Time: 10:46 PM
 */
public class UserAddRequest
{
    private String firstName;

    private String lastName;

    public UserAddRequest() {
    }

    public UserAddRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
