package com.example.ticketboard.dto;

import com.example.ticketboard.domain.Incident;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

public class CommentCreateRequest {

    @NotNull
    private Incident incident;

    @Size(max = 255)
    private String author;

    @Size(max = 2000)
    private String message;

    public @NotNull Incident getIncident() {
        return incident;
    }

    public void setIncident(@NotNull Incident incident) {
        this.incident = incident;
    }

    public @Size(max = 255) String getAuthor() {
        return author;
    }

    public void setAuthor(@Size(max = 255) String author) {
        this.author = author;
    }

    public @Size(max = 2000) String getMessage() {
        return message;
    }

    public void setMessage(@Size(max = 2000) String message) {
        this.message = message;
    }
}
