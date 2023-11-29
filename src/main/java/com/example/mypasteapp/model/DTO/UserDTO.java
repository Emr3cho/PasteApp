package com.example.mypasteapp.model.DTO;

import com.example.mypasteapp.model.MyPaste;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String username;
    private String email;
    private int age;
    private List<MyPaste> favorites;

    public UserDTO(int id, String username, String email, int age, List<MyPaste> favorites) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
        this.favorites = favorites;
    }
}
