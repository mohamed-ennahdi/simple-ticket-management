package com.github.mohamedennahdi.simpleticketmanagement.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Comment;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findByTicket(Ticket ticket);
}
