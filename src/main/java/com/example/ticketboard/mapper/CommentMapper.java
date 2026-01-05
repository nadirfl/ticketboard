package com.example.ticketboard.mapper;

import com.example.ticketboard.domain.Comment;
import com.example.ticketboard.dto.CommentResponse;

public class CommentMapper {

    public CommentResponse toCommentResponseDto(Comment comment) {
        return new CommentResponse(
                comment.getId(),
                comment.getIncident(),
                comment.getAuthor(),
                comment.getMessage(),
                comment.getCreatedAt()
        );
    }
}
