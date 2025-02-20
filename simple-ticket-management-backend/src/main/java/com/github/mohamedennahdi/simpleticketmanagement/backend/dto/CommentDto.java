package com.github.mohamedennahdi.simpleticketmanagement.backend.dto;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;

import lombok.Data;

@Data
public class CommentDto {
	private Long id;
	private String text;
	
	private Ticket ticket;
}
