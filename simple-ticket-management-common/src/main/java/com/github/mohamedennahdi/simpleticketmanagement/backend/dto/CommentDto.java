package com.github.mohamedennahdi.simpleticketmanagement.backend.dto;

import lombok.Data;

@Data
public class CommentDto {
	private Long id;
	private String text;
	
	private TicketDto ticket;
}
