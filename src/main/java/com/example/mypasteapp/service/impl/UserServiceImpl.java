package com.example.mypasteapp.service.impl;

import com.example.mypasteapp.dao.UserRepository;
import com.example.mypasteapp.model.DTO.UserDTO;
import com.example.mypasteapp.model.DTO.requests.UpdateUserRequest;
import com.example.mypasteapp.model.DTO.requests.UserRequest;
import com.example.mypasteapp.model.DTO.responses.UserDetailedResponse;
import com.example.mypasteapp.model.DTO.responses.UserResponse;
import com.example.mypasteapp.model.MyPaste;
import com.example.mypasteapp.model.User;
import com.example.mypasteapp.service.MyPasteService;
import com.example.mypasteapp.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Invalid user"));
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getAge(), user.getFavorites());
    }

    @Override
    public User findUserEntityById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserDetailedResponse findUserById(int id) {
        return this.userToUserDetailedResponseMapper(this.findUserEntityById(id));
    }

    @Override
    public List<UserResponse> findAllUsers() {
        return userRepository.findAll().stream().map(this::userToUserResponseMapper).toList();
    }

    @Override
    public void saveNewUser(UserRequest userRequest) {
        userRepository.save(userRequestToUser(userRequest));
    }

    @Override
    public UserResponse updateUser(UpdateUserRequest updateUserRequest) {
        User user = this.findUserEntityById(updateUserRequest.getId());
        User updatedUserInDB = this.updateUserInDB(user, updateUserRequest);
        return this.userToUserResponseMapper(updatedUserInDB);
    }

    @Override
    public void deleteUserById(int userId) {
        userRepository.deleteById(userId);
    }


    private User userRequestToUser(UserRequest userRequest){
        return new User(userRequest.getUsername(), userRequest.getEmail(), userRequest.getPassword(), userRequest.getAge());
    }

    private UserResponse userToUserResponseMapper(User user){
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getAge());
    }
    private UserDetailedResponse userToUserDetailedResponseMapper(User user){
        List<MyPaste> favs = user.getFavorites();
        return new UserDetailedResponse(user.getId(), user.getUsername(), user.getEmail(), user.getAge(), user.getFavorites().stream().map(MyPasteServiceImpl::myPasteToMyPasteResponseMapperStatic).toList());
    }

    private User updateUserInDB(User user, UpdateUserRequest updateUserRequest){
        user.setUsername(updateUserRequest.getUsername());
        user.setEmail(updateUserRequest.getEmail());
        user.setAge(updateUserRequest.getAge());
        return userRepository.save(user);
    }
}
