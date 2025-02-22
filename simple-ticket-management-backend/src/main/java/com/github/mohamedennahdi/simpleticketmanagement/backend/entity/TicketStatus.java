package com.github.mohamedennahdi.simpleticketmanagement.backend.entity;

import java.time.LocalDateTime;

import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TicketStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private LocalDateTime assignmentDate;
}
