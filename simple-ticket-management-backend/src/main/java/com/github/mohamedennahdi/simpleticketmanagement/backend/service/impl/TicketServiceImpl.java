package com.github.mohamedennahdi.simpleticketmanagement.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.TicketDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;
import com.github.mohamedennahdi.simpleticketmanagement.backend.exception.UserEmployeeNotFoundException;
import com.github.mohamedennahdi.simpleticketmanagement.backend.mapper.TicketMapper;
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
	TicketMapper ticketMapper;

	@Override
	public List<TicketDto> findAll() {
		return ticketMapper.entitiesToDtos(ticketRepository.findAll());
	}

	@Override
	public Optional<Ticket> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public TicketDto create(TicketDto ticketDto) throws UserEmployeeNotFoundException {
		UserEmployee userEmployee = userEmployeeRepository.findById(ticketDto.getUserEmployee().getId()).orElseThrow(() -> new UserEmployeeNotFoundException());
		Ticket ticket = ticketMapper.dtoToEntity(ticketDto);
		ticket.setUserEmployee(userEmployee);
		
		return ticketMapper.entityToDto(ticketRepository.save(ticket));
	}

	@Override
	public List<TicketDto> findByEmployee(Long employeeId) throws UserEmployeeNotFoundException {
		UserEmployee employee = this.userEmployeeRepository.findById(employeeId).orElseThrow(() -> new UserEmployeeNotFoundException());
		
		List<Ticket> t = this.ticketRepository.findByUserEmployee(employee);
		
		return ticketMapper.entitiesToDtos(t);
	}


}
