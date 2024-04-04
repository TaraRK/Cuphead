package com.example.demo1.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Database {
    private ArrayList<User> users;
    private static User player;

    public File file;
    public FileWriter fileWriter;
    public PrintWriter printWriter;
    public Database()
    {
        this.users = new ArrayList<>();

    }

    public User getUser( String username, String password)
    {
        for ( User user: this.users)
        {
            if ( user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(String username, String password)
    {
        try {
            this.printWriter = new PrintWriter("Players.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        User user = new User(username, password);
        this.printWriter.println(user.getUsername() + " " + user.getPassword());
        this.users.add(user);
        printWriter.close();
    }

    public static User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public boolean userWithSameUsernameExists( String username)
    {
        for (User user : this.users)
        {
            if ( user.getUsername().equals(username))
            {
                return true;
            }

        }
        return false;
    }

    public void removeUser ( User user)
    {
        this.users.remove(user);
    }

    public void sort()
    {
        this.users.sort(Comparator.comparing(User :: getScore));
    }
}
