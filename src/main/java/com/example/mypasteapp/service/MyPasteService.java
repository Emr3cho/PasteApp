package com.example.mypasteapp.service;

import com.example.mypasteapp.model.DTO.requests.MyPasteRequest;
import com.example.mypasteapp.model.DTO.requests.UpdateMyPasteRequest;
import com.example.mypasteapp.model.DTO.responses.MyPasteResponse;
import com.example.mypasteapp.model.MyPaste;

import java.util.List;
import java.util.UUID;

public interface MyPasteService {
    MyPaste getPasteEntityById(UUID pasteId);
    List<MyPasteResponse> getAllPastes();
    void saveNewPaste(MyPasteRequest pasteRequest);
    List<MyPasteResponse> getAllPastesByUserId(int userId);
    MyPasteResponse updatePaste(UpdateMyPasteRequest updateUserRequest);
    void deletePasteById(UUID id);
}
