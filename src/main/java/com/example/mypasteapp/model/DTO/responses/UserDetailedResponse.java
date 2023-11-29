package com.example.mypasteapp.model.DTO.responses;

import com.example.mypasteapp.model.MyPaste;

import java.util.List;

public class UserDetailedResponse{
    private int id;
    private String username;
    private String email;
    private int age;
    private List<MyPasteResponse> favorites;

    public UserDetailedResponse(int id, String username, String email, int age, List<MyPasteResponse> favorites) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
        this.favorites = favorites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<MyPasteResponse> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<MyPasteResponse> favorites) {
        this.favorites = favorites;
    }
}
