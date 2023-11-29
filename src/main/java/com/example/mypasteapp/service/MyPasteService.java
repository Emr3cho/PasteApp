package com.example.mypasteapp.service;

import com.example.mypasteapp.model.DTO.requests.MyPasteRequest;
import com.example.mypasteapp.model.DTO.responses.MyPasteResponse;
import com.example.mypasteapp.model.MyPaste;

import java.util.List;

public interface MyPasteService {
    List<MyPasteResponse> getAllPastes();
    void saveNewPaste(MyPasteRequest pasteRequest);
    List<MyPasteResponse> getAllPastesByUserId(int userId);
}
