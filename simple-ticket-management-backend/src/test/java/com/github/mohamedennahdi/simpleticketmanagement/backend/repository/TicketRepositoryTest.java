package com.github.mohamedennahdi.simpleticketmanagement.backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.TicketStatus;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;
import com.github.mohamedennahdi.simpleticketmanagement.backend.factory.TicketFactory;
import com.github.mohamedennahdi.simpleticketmanagement.backend.factory.TicketStatusFactory;
import com.github.mohamedennahdi.simpleticketmanagement.backend.factory.UserEmployeeFactory;

@DataJpaTest
public class TicketRepositoryTest {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	TicketStatusRepository ticketStatusRepository;
	
	@Autowired
	UserEmployeeRepository userRepository;
	
	@Test
    void saveTest() {
		Ticket t = TicketFactory.make();
		assertNull(t.getId());
		t = ticketRepository.save(t);
		assertNotNull(t.getId());
		
    }
	
	@Test
	void findAllTest() {
		Set<TicketStatus> statuses = new HashSet<>();
		statuses.add(ticketStatusRepository.save(TicketStatusFactory.make()));
		statuses.add(ticketStatusRepository.save(TicketStatusFactory.make()));
		statuses.add(ticketStatusRepository.save(TicketStatusFactory.make()));
		statuses.add(ticketStatusRepository.save(TicketStatusFactory.make()));
		statuses.add(ticketStatusRepository.save(TicketStatusFactory.make()));
		
		ticketRepository.save(TicketFactory.make(statuses));
		ticketRepository.save(TicketFactory.make());
		ticketRepository.save(TicketFactory.make());
		ticketRepository.save(TicketFactory.make());
		
		assertEquals(4, ticketRepository.findAll().size()); 
	}
	
	@Test
	void findByUserEmployeeTest() {
		
		
		UserEmployee ue = UserEmployeeFactory.make();
		ue = userRepository.save(ue);
		ticketRepository.save(TicketFactory.make(ue));
		ticketRepository.save(TicketFactory.make(ue));
		ticketRepository.save(TicketFactory.make(ue));
		ticketRepository.save(TicketFactory.make(ue));
		ticketRepository.save(TicketFactory.make(ue));
		ticketRepository.save(TicketFactory.make(ue));
		ticketRepository.save(TicketFactory.make(ue));
		ticketRepository.save(TicketFactory.make(ue));
		ticketRepository.save(TicketFactory.make(ue));
		ticketRepository.save(TicketFactory.make(ue));
		
		assertEquals(10, ticketRepository.findByUserEmployee(ue).size()); 
	}
}
