package com.example.mypasteapp.service.impl;

import com.example.mypasteapp.dao.CommentRepository;
import com.example.mypasteapp.model.DTO.requests.CommentRequest;
import com.example.mypasteapp.model.DTO.requests.UpdateCommentRequest;
import com.example.mypasteapp.model.DTO.responses.CommentResponse;
import com.example.mypasteapp.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void addCommentToPaste(UUID pasteId, CommentRequest commentRequest) {

    }

    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentResponse getCommentById(int id) {
        return null;
    }

    @Override
    public CommentResponse updateComment(UpdateCommentRequest updateCommentRequest) {
        return null;
    }
}
