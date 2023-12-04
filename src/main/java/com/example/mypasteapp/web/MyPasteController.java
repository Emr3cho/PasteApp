package com.example.mypasteapp.web;

import com.example.mypasteapp.model.DTO.requests.MyPasteRequest;
import com.example.mypasteapp.model.DTO.requests.UpdateMyPasteRequest;
import com.example.mypasteapp.model.DTO.requests.UpdateUserRequest;
import com.example.mypasteapp.model.DTO.responses.MyPasteResponse;
import com.example.mypasteapp.model.DTO.responses.UserResponse;
import com.example.mypasteapp.model.MyPaste;
import com.example.mypasteapp.service.MyPasteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

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

    @PutMapping("/{id}")
    public ResponseEntity<MyPasteResponse> getUserById(@RequestBody UpdateMyPasteRequest updateUserRequest) {
        return new ResponseEntity<MyPasteResponse>(myPasteService.updatePaste(updateUserRequest), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MyPasteResponse>> allPastes(Principal principal) {
        return new ResponseEntity<>(myPasteService.getAllPastes(), HttpStatus.OK);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<?> getAllPastesByIdUserId(@PathVariable int userId){
        return new ResponseEntity<>(myPasteService.getAllPastesByUserId(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable UUID id) {
        myPasteService.deletePasteById(id);
        return new ResponseEntity<>("user with id " + id + "is deleted successfully!", HttpStatus.OK);
    }
}
