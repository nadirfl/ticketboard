package com.example.ticketboard.service;

import com.example.ticketboard.domain.Comment;
import com.example.ticketboard.domain.Incident;
import com.example.ticketboard.dto.CommentCreateRequest;
import com.example.ticketboard.dto.CommentResponse;
import com.example.ticketboard.exceptions.CommentNotFoundException;
import com.example.ticketboard.exceptions.IncidentNotFoundException;
import com.example.ticketboard.mapper.CommentMapper;
import com.example.ticketboard.repository.CommentRepository;
import com.example.ticketboard.repository.IncidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService{

    CommentRepository commentRepository;
    CommentMapper commentMapper;
    IncidentRepository incidentRepository;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper, IncidentRepository incidentRepository) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.incidentRepository = incidentRepository;
    }

    @Override
    public List<CommentResponse> getCommentsFromIncident(Long incidentID) {
        return commentRepository.findByIncidentIdOrderByCreatedAtDesc(incidentID)
                .stream()
                .map(commentMapper::toCommentResponseDto)
                .toList();
    }

    @Override
    public CommentResponse createCommentForIncident(CommentCreateRequest commentCreateRequest) {

        Incident incident = incidentRepository.findById(commentCreateRequest.getIncident().getId())
                .orElseThrow(() -> new IncidentNotFoundException(commentCreateRequest.getIncident().getId()));

        Comment comment = new Comment();
        comment.setIncident(commentCreateRequest.getIncident());
        comment.setAuthor(commentCreateRequest.getAuthor());
        comment.setMessage(commentCreateRequest.getMessage());

        Comment saved = commentRepository.save(comment);
        return commentMapper.toCommentResponseDto(saved);
    }
}
