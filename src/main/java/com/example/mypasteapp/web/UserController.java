package com.example.mypasteapp.web;

import com.example.mypasteapp.model.DTO.requests.UpdateUserRequest;
import com.example.mypasteapp.model.DTO.requests.UserRequest;
import com.example.mypasteapp.model.DTO.responses.UserDetailedResponse;
import com.example.mypasteapp.model.DTO.responses.UserResponse;
import com.example.mypasteapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailedResponse> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@RequestBody UpdateUserRequest updateUserRequest) {
        return new ResponseEntity<>(userService.updateUser(updateUserRequest), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> saveNewUser(@RequestBody UserRequest userRequest) {
        userService.saveNewUser(userRequest);
        return new ResponseEntity<>("new user is saved successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("user with id " + id + "is deleted successfully!", HttpStatus.OK);
    }
}
