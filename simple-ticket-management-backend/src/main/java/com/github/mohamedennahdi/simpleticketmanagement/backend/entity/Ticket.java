package com.github.mohamedennahdi.simpleticketmanagement.backend.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Category;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Priority;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Transient;
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

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "ticket_id")
	@OrderBy("assignmentDate DESC")
	private Set<TicketStatus> statuses;

	@Transient
	private TicketStatus lastStatus;

	@PostLoad
	private void setLastBook() {
		if (CollectionUtils.isEmpty(statuses)) {
			this.statuses = null;
		} else {
			this.lastStatus = new ArrayList<>(statuses).get(0);
		}
	}

	@ManyToOne
	@JoinColumn(name = "user_employee_id")
	private UserEmployee userEmployee;
}
