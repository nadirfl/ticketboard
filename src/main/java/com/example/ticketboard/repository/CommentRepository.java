package com.example.ticketboard.repository;

import com.example.ticketboard.domain.Comment;
import com.example.ticketboard.domain.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByIncident(Incident incident);
}
