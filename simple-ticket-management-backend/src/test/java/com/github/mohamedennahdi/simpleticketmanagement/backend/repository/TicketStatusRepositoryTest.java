package com.github.mohamedennahdi.simpleticketmanagement.backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.mohamedennahdi.simpleticketmanagement.backend.factory.TicketStatusFactory;

@DataJpaTest
public class TicketStatusRepositoryTest {
	
	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	TicketStatusRepository ticketStatusRepository;
	
	@Test
    public void saveTest() {
//		Ticket t = TicketFactory.make();
//		assertNull(t.getId());
//		t = ticketRepository.save(t);
//		assertNotNull(t.getId());
//		TicketStatus ts = TicketStatusFactory.make();
//		assertNull(ts.getId());
//		ticketStatusRepository.save(ts);
//		assertNotNull(ts.getId());
		
    }
	
	@Test
	public void findAllTest() {
		
//		Ticket t = TicketFactory.make();
//		t = ticketRepository.save(t);
		
		ticketStatusRepository.save(TicketStatusFactory.make());
		ticketStatusRepository.save(TicketStatusFactory.make());
		ticketStatusRepository.save(TicketStatusFactory.make());
		ticketStatusRepository.save(TicketStatusFactory.make());
		ticketStatusRepository.save(TicketStatusFactory.make());
		
		assertEquals(5, ticketStatusRepository.findAll().size());
	}
}
