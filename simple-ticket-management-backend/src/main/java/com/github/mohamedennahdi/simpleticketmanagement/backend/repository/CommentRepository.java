package com.github.mohamedennahdi.simpleticketmanagement.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
