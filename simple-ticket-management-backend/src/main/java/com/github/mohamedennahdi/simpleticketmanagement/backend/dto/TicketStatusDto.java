package com.github.mohamedennahdi.simpleticketmanagement.backend.dto;

import java.sql.Date;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Status;

import lombok.Data;

@Data
public class TicketStatusDto {
    private Ticket ticket;
	
	private Status status;
	
	private Date assignmentDate;
}
