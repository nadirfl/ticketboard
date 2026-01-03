package com.example.ticketboard.dto;

import com.example.ticketboard.domain.Incident;

import java.time.LocalDateTime;

public record CommentDto(Incident incident, String author, String message, LocalDateTime createdAt) {
}
