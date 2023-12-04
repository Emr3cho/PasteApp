package com.example.mypasteapp.web;

import com.example.mypasteapp.model.DTO.requests.CommentRequest;
import com.example.mypasteapp.model.DTO.requests.UpdateCommentRequest;
import com.example.mypasteapp.model.DTO.responses.CommentResponse;
import com.example.mypasteapp.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping()
    public ResponseEntity<Object> addCommentToPaste(@RequestParam UUID pasteId,
                                                    @RequestBody CommentRequest commentRequest){
        return null;
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentResponse> getCommentById(@PathVariable int commentId){
        return null;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CommentResponse>> showAllComments(){
        return null;
    }

    @PutMapping()
    public ResponseEntity<CommentResponse> updateComment(@RequestBody UpdateCommentRequest updateCommentRequest) {
           return null;
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Object> deleteComment(@PathVariable int commentId){
        return null;
    }
}
