package com.github.mohamedennahdi.simpleticketmanagement.backend.entity;

import java.sql.Date;

import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Category;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Priority;

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
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	@Enumerated(EnumType.STRING)
	private Category category;
	private Date creationDate;
	
	@ManyToOne
	@JoinColumn(name = "user_employee_id")
	private UserEmployee userEmployee;
}
