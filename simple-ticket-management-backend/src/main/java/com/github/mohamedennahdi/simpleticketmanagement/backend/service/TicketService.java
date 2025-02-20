package com.github.mohamedennahdi.simpleticketmanagement.backend.service;

import java.util.List;
import java.util.Optional;

import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.TicketDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;
import com.github.mohamedennahdi.simpleticketmanagement.backend.exception.UserEmployeeNotFoundException;

public interface TicketService {
	List<Ticket> findAll();
	List<Ticket> findByEmployee(Long employeeId) throws UserEmployeeNotFoundException;
	Optional<Ticket> findById(Long id);
	Optional<Ticket> create(TicketDto ticket);
}
