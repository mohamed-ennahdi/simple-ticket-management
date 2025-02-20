package com.github.mohamedennahdi.simpleticketmanagement.backend.entity;

import java.sql.Date;

import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class TicketStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private Date assignmentDate;
}
