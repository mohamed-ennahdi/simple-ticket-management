package com.github.mohamedennahdi.simpleticketmanagement.backend.repository;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Category;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Priority;
import com.github.mohamedennahdi.simpleticketmanagement.backend.factory.TicketFactory;

@DataJpaTest
public class TicketRepositoryTest {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Test
    public void saveTest() {
		Ticket t = TicketFactory.make();
		ticketRepository.save(t);
		
    }
	
	@Test
	public void findAllTest() {
		
		ticketRepository.save(TicketFactory.make());
		ticketRepository.save(TicketFactory.make());
		ticketRepository.save(TicketFactory.make());
		ticketRepository.save(TicketFactory.make());
		
		 ticketRepository.findAll()
		.forEach(t -> System.out.println(t));
	}
}
