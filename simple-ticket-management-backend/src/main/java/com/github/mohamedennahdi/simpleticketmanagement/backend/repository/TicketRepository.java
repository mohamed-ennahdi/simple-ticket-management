package com.github.mohamedennahdi.simpleticketmanagement.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	List<Ticket> findByUserEmployee(UserEmployee userEmployee);
}
