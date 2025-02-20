package com.github.mohamedennahdi.simpleticketmanagement.backend.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.TicketStatus;
import com.github.mohamedennahdi.simpleticketmanagement.backend.factory.TicketFactory;
import com.github.mohamedennahdi.simpleticketmanagement.backend.factory.TicketStatusFactory;

@DataJpaTest
public class TicketStatusRepositoryTest {
	
	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	TicketStatusRepository ticketStatusRepository;
	
	@Test
    public void saveTest() {
		Ticket t = TicketFactory.make();
		t = ticketRepository.save(t);
		TicketStatus ts = TicketStatusFactory.make(t);
		ticketStatusRepository.save(ts);
		
    }
	
	@Test
	public void findAllTest() {
		
		Ticket t = TicketFactory.make();
		t = ticketRepository.save(t);
		
		ticketStatusRepository.save(TicketStatusFactory.make(t));
		ticketStatusRepository.save(TicketStatusFactory.make(t));
		ticketStatusRepository.save(TicketStatusFactory.make(t));
		ticketStatusRepository.save(TicketStatusFactory.make(t));
		
		ticketStatusRepository.findAll()
		.forEach(tstatus -> System.out.println(tstatus));
	}
}
