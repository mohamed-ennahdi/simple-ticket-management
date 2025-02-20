package com.github.mohamedennahdi.simpleticketmanagement.backend.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Comment;

@DataJpaTest
public class CommentRepositoryTest {
	@Autowired
	CommentRepository commentRepository;
	
	@Test
    public void saveTest() {
		commentRepository.save(new Comment());
    }
	
	@Test
	public void findAllTest() {
		
		commentRepository.save(new Comment());
		commentRepository.save(new Comment());
		commentRepository.save(new Comment());
		commentRepository.save(new Comment());
		
		List<Comment> comments = commentRepository.findAll();
		comments.forEach(c -> System.out.println(c));
	}
}
