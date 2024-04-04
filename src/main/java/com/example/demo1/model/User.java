package com.example.demo1.model;

public class User {
    private String username;
    private String password;
    private int score;
    private int number;

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.score = 0;
        this.number = username.length() % 7;
        if ( this.number == 0)
        {
            this.number = 1;
        }
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
