package com.example.mypasteapp.web;

import com.example.mypasteapp.model.DTO.requests.MyPasteRequest;
import com.example.mypasteapp.model.DTO.responses.MyPasteResponse;
import com.example.mypasteapp.model.MyPaste;
import com.example.mypasteapp.service.MyPasteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paste")
public class MyPasteController {
    private final MyPasteService myPasteService;

    public MyPasteController(MyPasteService myPasteService) {
        this.myPasteService = myPasteService;
    }

    @PostMapping()
    public ResponseEntity<Object> saveNewPaste(@RequestBody MyPasteRequest myPasteRequest){
        myPasteService.saveNewPaste(myPasteRequest);
        return new ResponseEntity<>("saved successfully!", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MyPasteResponse>> allPastes() {
        return new ResponseEntity<>(myPasteService.getAllPastes(), HttpStatus.OK);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<?> getAllPastesByIdUserId(@PathVariable int userId){
        return new ResponseEntity<>(myPasteService.getAllPastesByUserId(userId), HttpStatus.OK);
    }
}
