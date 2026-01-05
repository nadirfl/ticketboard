package com.example.ticketboard.service;

import com.example.ticketboard.domain.Comment;
import com.example.ticketboard.dto.CommentCreateRequest;
import com.example.ticketboard.dto.CommentResponse;
import com.example.ticketboard.mapper.CommentMapper;
import com.example.ticketboard.repository.CommentRepository;

import java.util.List;

public class CommentService implements ICommentService{

    CommentRepository commentRepository;
    CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentResponse> getCommentsFromIncident(Long incidentID) {
        return commentRepository.findByIncidentID(incidentID)
                .stream()
                .map(commentMapper::toCommentResponseDto)
                .toList();
    }

    @Override
    public CommentResponse createCommentForIncident(CommentCreateRequest commentCreateRequest) {
        Comment comment = new Comment();
        comment.setIncident(commentCreateRequest.getIncident());
        comment.setAuthor(commentCreateRequest.getAuthor());
        comment.setMessage(commentCreateRequest.getMessage());

        Comment saved = commentRepository.save(comment);
        return commentMapper.toCommentResponseDto(saved);
    }
}
