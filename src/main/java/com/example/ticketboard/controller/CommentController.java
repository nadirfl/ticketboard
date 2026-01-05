package com.example.ticketboard.controller;

import com.example.ticketboard.dto.CommentCreateRequest;
import com.example.ticketboard.dto.CommentResponse;
import com.example.ticketboard.service.ICommentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidents/{id}/comments")
public class CommentController {

    private final ICommentService commentService;

    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable Long incidentID) {
        return ResponseEntity.ok(commentService.getCommentsFromIncident(incidentID));
    }

    @PostMapping
    public ResponseEntity<CommentResponse> createComment(
            @PathVariable Long incidentID,
            @Valid @RequestBody CommentCreateRequest createRequest
    ) {
        return ResponseEntity.ok(commentService.createCommentForIncident(createRequest));
    }

}
