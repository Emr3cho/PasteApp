package com.example.mypasteapp.service.impl;

import com.example.mypasteapp.dao.MyPasteRepository;
import com.example.mypasteapp.model.DTO.requests.MyPasteRequest;
import com.example.mypasteapp.model.DTO.responses.MyPasteResponse;
import com.example.mypasteapp.model.MyPaste;
import com.example.mypasteapp.model.User;
import com.example.mypasteapp.service.MyPasteService;
import com.example.mypasteapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyPasteServiceImpl implements MyPasteService {

    private final MyPasteRepository myPasteRepository;

    private final UserService userService;

    public MyPasteServiceImpl(MyPasteRepository myPasteRepository, UserService userService) {
        this.myPasteRepository = myPasteRepository;
        this.userService = userService;
    }

    @Override
    public List<MyPasteResponse> getAllPastes() {
        return myPasteRepository.findAll().stream().map(this::myPasteToMyPasteResponseMapper).toList();
    }

    @Override
    public void saveNewPaste(MyPasteRequest myPasteRequest) {
        myPasteRepository.save(myPasteRequestToMyPasteMapper(myPasteRequest));
    }

    @Override
    public List<MyPasteResponse> getAllPastesByUserId(int userId) {
        return myPasteRepository.findAllByUserId(userId).stream().map(this::myPasteToMyPasteResponseMapper).toList();
    }

    private MyPaste myPasteRequestToMyPasteMapper(MyPasteRequest myPasteRequest) {
        User user = userService.findUserEntityById(myPasteRequest.getUserId());
        return new MyPaste(myPasteRequest.getTitle(), myPasteRequest.getContent(), user);
    }

    private MyPasteResponse myPasteToMyPasteResponseMapper(MyPaste myPaste) {
        return new MyPasteResponse(myPaste.getId(), myPaste.getTitle(), myPaste.getContent(), myPaste.getCreatedOn(), myPaste.getLastUpdatedOn(), myPaste.getUser().getId());
    }
    public static MyPasteResponse myPasteToMyPasteResponseMapperStatic(MyPaste myPaste) {
        return new MyPasteResponse(myPaste.getId(), myPaste.getTitle(), myPaste.getContent(), myPaste.getCreatedOn(), myPaste.getLastUpdatedOn(), myPaste.getUser().getId());
    }

}
