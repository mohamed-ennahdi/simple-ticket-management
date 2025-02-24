package com.github.mohamedennahdi.simpleticketmanagement.backend.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.TicketDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.UserEmployeeDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;
import com.github.mohamedennahdi.simpleticketmanagement.backend.mapper.TicketMapper;
import com.github.mohamedennahdi.simpleticketmanagement.backend.repository.TicketRepository;
import com.github.mohamedennahdi.simpleticketmanagement.backend.repository.UserEmployeeRepository;

import jakarta.annotation.Generated;

@Generated(value = "org.junit-tools-1.1.0")
@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {

	@Mock
	TicketRepository ticketRepository;
	
	@Mock
	UserEmployeeRepository userEmployeeRepository;
	
	@InjectMocks
	TicketServiceImpl ticketService;
	
	@Mock
	TicketMapper ticketMapper;
	
	@Test
	public void createTest() throws Exception {
		
		Optional<UserEmployee> oue = Optional.of(mock(UserEmployee.class));
		when(userEmployeeRepository.findById(anyLong())).thenReturn(oue);
		when(ticketMapper.dtoToEntity(any(TicketDto.class))).thenReturn(mock(Ticket.class));
		when(ticketMapper.entityToDto(any(Ticket.class))).thenReturn(mock(TicketDto.class));
		when(ticketRepository.save(any(Ticket.class))).thenReturn(mock(Ticket.class));
		TicketDto ticketDto = mock(TicketDto.class);
		UserEmployeeDto dto = mock(UserEmployeeDto.class);
		when(dto.getId()).thenReturn(RandomUtils.nextLong(0, 1000));
		when(ticketDto.getUserEmployee()).thenReturn(dto);
		TicketDto actual = ticketService.create(ticketDto);
		
		assertNotNull(actual);
	}

	@Disabled
	@Test
	public void findAllTest() throws Exception {
		List<TicketDto> result;

		// default test
		result = ticketService.findAll();
	}

	@Disabled
	@Test
	public void findByEmployeeTest() throws Exception {
		Long employeeId = null;
		List<TicketDto> result;

		// default test
		result = ticketService.findByEmployee(employeeId);
	}

	@Disabled
	@Test
	public void findByIdTest() throws Exception {
		Long id = null;
		Optional<Ticket> result;

		// default test
		result = ticketService.findById(id);
	}
}