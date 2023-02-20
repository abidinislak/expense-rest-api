package com.example.demo.dataUtils;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserModel {


    @NotBlank(message = "name can not be null or blak")
    private String name;

    @Email(message = "please check e ail")
    @NotBlank(message = "email can not be null or empty")
    private String email;
    @Size(min = 5, message = "password can not be less than 56 caracter")

    private String password;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
