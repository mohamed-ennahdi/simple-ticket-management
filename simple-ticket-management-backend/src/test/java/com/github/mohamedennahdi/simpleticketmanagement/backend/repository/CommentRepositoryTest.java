package com.github.mohamedennahdi.simpleticketmanagement.backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Comment;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;
import com.github.mohamedennahdi.simpleticketmanagement.backend.factory.CommentFactory;
import com.github.mohamedennahdi.simpleticketmanagement.backend.factory.TicketFactory;

@DataJpaTest
public class CommentRepositoryTest {
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Test
    public void saveTest() {
		Ticket ticket = TicketFactory.make();
		ticket = ticketRepository.save(ticket);
		
		Comment comment = CommentFactory.make(ticket);
		assertNull(comment.getId());
		comment = commentRepository.save(comment);
		assertNotNull(comment.getId());
    }
	
	@Test
	public void findAllTest() {
		Ticket ticket = TicketFactory.make();
		ticket = ticketRepository.save(ticket);
		
		commentRepository.save(CommentFactory.make(ticket));
		commentRepository.save(CommentFactory.make(ticket));
		commentRepository.save(CommentFactory.make(ticket));
		commentRepository.save(CommentFactory.make(ticket));
		commentRepository.save(CommentFactory.make(ticket));
		
		assertEquals(5, commentRepository.findByTicket(ticket).size());
	}
	
	@Test
	public void findByTicketTest() {

		Ticket ticket = TicketFactory.make();
		ticket = ticketRepository.save(ticket);
		
		commentRepository.save(CommentFactory.make(ticket));
		commentRepository.save(CommentFactory.make(ticket));
		commentRepository.save(CommentFactory.make(ticket));
		commentRepository.save(CommentFactory.make(ticket));
		commentRepository.save(CommentFactory.make(ticket));
		commentRepository.save(CommentFactory.make(ticket));
		commentRepository.save(CommentFactory.make(ticket));
		commentRepository.save(CommentFactory.make(ticket));
		commentRepository.save(CommentFactory.make(ticket));
		commentRepository.save(CommentFactory.make(ticket));
		
		assertEquals(10, commentRepository.findByTicket(ticket).size());
	}
}
