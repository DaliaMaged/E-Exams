package com.example.e_exams;

public class User {
    private String name,email,password;
public User(String email, String password) {

    this.email = email;
    this.password = password;

}
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

