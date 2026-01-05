package com.example.ticketboard.service;

import com.example.ticketboard.dto.CommentCreateRequest;
import com.example.ticketboard.dto.CommentResponse;

import java.util.List;

public interface ICommentService {

    List<CommentResponse> getCommentsFromIncident(Long incidentID);

    CommentResponse createCommentForIncident(CommentCreateRequest commentCreateRequest);
}
