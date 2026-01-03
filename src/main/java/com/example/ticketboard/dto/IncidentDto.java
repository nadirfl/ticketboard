package com.example.ticketboard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class IncidentDto {

    @NotBlank
    @Size(max = 255)
    private String title;

    @Size(max = 2000)
    private String description;

    public @NotBlank @Size(max = 255) String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank @Size(max = 255) String title) {
        this.title = title;
    }

    public @Size(max = 2000) String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 2000) String description) {
        this.description = description;
    }
}
