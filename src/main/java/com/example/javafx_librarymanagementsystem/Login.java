package com.example.javafx_librarymanagementsystem;

public class Login {
    private String username;
    private int password;
    public Login (String username, int password){
        this.username=username;
        this.password=password;
    }
    public String getUsername(){
        return username;
    }
    public int getPassword(){
        return password;
    }
}
