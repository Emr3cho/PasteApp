package com.example.mypasteapp.service.impl;

import com.example.mypasteapp.dao.MyPasteRepository;
import com.example.mypasteapp.model.DTO.requests.MyPasteRequest;
import com.example.mypasteapp.model.DTO.requests.UpdateMyPasteRequest;
import com.example.mypasteapp.model.DTO.responses.MyPasteResponse;
import com.example.mypasteapp.model.MyPaste;
import com.example.mypasteapp.model.User;
import com.example.mypasteapp.service.MyPasteService;
import com.example.mypasteapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    @Override
    public MyPasteResponse updatePaste(UpdateMyPasteRequest updateUserRequest) {
        MyPaste pasteInDB = this.getPasteEntityById(updateUserRequest.getId());
        MyPaste updatedPaste = this.updateSavedPaste(pasteInDB, updateUserRequest);
        return this.myPasteToMyPasteResponseMapper(updatedPaste);
    }

    @Override
    public void deletePasteById(UUID id) {
        myPasteRepository.deleteById(id);
    }

    public MyPaste getPasteEntityById(UUID pasteId){
        return myPasteRepository.findById(pasteId).get();
    }

    private MyPaste myPasteRequestToMyPasteMapper(MyPasteRequest myPasteRequest) {
        User user = userService.findUserEntityById(myPasteRequest.getUserId());
        return new MyPaste(myPasteRequest.getTitle(), myPasteRequest.getContent(), user);
    }


    private MyPaste updateSavedPaste(MyPaste myPaste, UpdateMyPasteRequest updateMyPasteRequest){
        myPaste.setTitle(updateMyPasteRequest.getTitle());
        myPaste.setContent(updateMyPasteRequest.getContent());
        return myPasteRepository.save(myPaste);
    }

    private MyPasteResponse myPasteToMyPasteResponseMapper(MyPaste myPaste) {
        return new MyPasteResponse(myPaste.getId(), myPaste.getTitle(), myPaste.getContent(), myPaste.getCreatedOn(), myPaste.getLastUpdatedOn(), myPaste.getUser().getId());
    }
    public static MyPasteResponse myPasteToMyPasteResponseMapperStatic(MyPaste myPaste) {
        return new MyPasteResponse(myPaste.getId(), myPaste.getTitle(), myPaste.getContent(), myPaste.getCreatedOn(), myPaste.getLastUpdatedOn(), myPaste.getUser().getId());
    }

}
