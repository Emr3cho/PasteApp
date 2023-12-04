package com.example.mypasteapp.service;

import com.example.mypasteapp.model.DTO.requests.CommentRequest;
import com.example.mypasteapp.model.DTO.requests.UpdateCommentRequest;
import com.example.mypasteapp.model.DTO.responses.CommentResponse;

import java.util.UUID;

public interface CommentService {
    void addCommentToPaste(UUID pasteId, CommentRequest commentRequest);
    void deleteComment(int id);
    CommentResponse getCommentById(int id);
    CommentResponse updateComment(UpdateCommentRequest updateCommentRequest);
}
