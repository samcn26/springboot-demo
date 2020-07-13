package com.sam_tech.test_springboot.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {

    // @edu work with @Valid
    @NotNull(message = "Can not be null")
    @Size(min = 2, message = "Length > 2")
    private String firstName;

    @NotNull(message = "Can not be null")
    @Size(min = 2, message = "Length > 2")
    private String lastName;

    @NotNull(message = "Can not be null")
    @Email
    private String email;

    @Size(min = 8, max = 16, message = "Password length between 8-16")
    private String password;

    public UserDetailsRequestModel(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
