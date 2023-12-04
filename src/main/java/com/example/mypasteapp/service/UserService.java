package com.example.mypasteapp.service;

import com.example.mypasteapp.model.DTO.UserDTO;
import com.example.mypasteapp.model.DTO.requests.UpdateUserRequest;
import com.example.mypasteapp.model.DTO.requests.UserRequest;
import com.example.mypasteapp.model.DTO.responses.UserDetailedResponse;
import com.example.mypasteapp.model.DTO.responses.UserResponse;
import com.example.mypasteapp.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserDTO findUserByUsername(String username);
    User findUserEntityById(int id);
    UserDetailedResponse findUserById(int id);
    List<UserResponse> findAllUsers();
    void saveNewUser(UserRequest userRequest);
    UserResponse updateUser(UpdateUserRequest updateUserRequest);
    void deleteUserById(int userId);
    void saveUserFavorite(int userId, UUID pasteId);
}
