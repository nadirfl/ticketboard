package com.example.ticketboard.exceptions;

import com.example.ticketboard.controller.CommentController;

public class CommentNotFoundException extends RuntimeException {

    public CommentNotFoundException(Long id) {
        super("Comment not found: " + id);
    }
}
