package com.github.mohamedennahdi.simpleticketmanagement.backend.dto;

import java.time.LocalDateTime;

import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Status;

import lombok.Data;

@Data
public class TicketStatusDto {
    private TicketDto ticket;
	
	private Status status;
	
	private LocalDateTime assignmentDate;
}
