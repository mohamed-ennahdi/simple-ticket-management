package com.github.mohamedennahdi.simpleticketmanagement.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.TicketDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.exception.UserEmployeeNotFoundException;
import com.github.mohamedennahdi.simpleticketmanagement.backend.service.TicketService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@RestController
@AllArgsConstructor
@RequestMapping("/tickets")
public class TicketController {

	TicketService ticketService;
	
	@GetMapping( value = "/{employeeId}" )
	public ResponseEntity<List<TicketDto>> getTicketsByEmployee(@PathVariable("employeeId") Long employeeId) {
		try {
			List<TicketDto> dtos = ticketService.findByEmployee(employeeId);
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} catch (UserEmployeeNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping( value = "/" )
	public ResponseEntity<List<TicketDto>> getAllTickets() {
		List<TicketDto> dtos = ticketService.findAll();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PostMapping( value = "/" )
	public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
		try {
			return new ResponseEntity<>(ticketService.create(ticketDto), HttpStatus.CREATED);
		} catch (UserEmployeeNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
