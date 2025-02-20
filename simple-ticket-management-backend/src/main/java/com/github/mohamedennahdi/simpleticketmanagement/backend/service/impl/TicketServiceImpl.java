package com.github.mohamedennahdi.simpleticketmanagement.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.TicketDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;
import com.github.mohamedennahdi.simpleticketmanagement.backend.exception.UserEmployeeNotFoundException;
import com.github.mohamedennahdi.simpleticketmanagement.backend.repository.TicketRepository;
import com.github.mohamedennahdi.simpleticketmanagement.backend.repository.UserEmployeeRepository;
import com.github.mohamedennahdi.simpleticketmanagement.backend.service.TicketService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
@Transactional
public class TicketServiceImpl implements TicketService {
	
	TicketRepository ticketRepository;
	UserEmployeeRepository userEmployeeRepository;

	@Override
	public List<Ticket> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Ticket> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Ticket> create(TicketDto ticket) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Ticket> findByEmployee(Long employeeId) throws UserEmployeeNotFoundException {
		UserEmployee employee = this.userEmployeeRepository.findById(employeeId).orElseThrow(() -> new UserEmployeeNotFoundException());
		return this.ticketRepository.findByUserEmployee(employee);
	}


}
