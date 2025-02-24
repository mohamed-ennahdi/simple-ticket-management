package com.github.mohamedennahdi.simpleticketmanagement.backend.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Category;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Priority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String description;
	private Priority priority;
	private Category category;
	private Date creationDate;
	
	private TicketStatusDto lastStatus;
	
	private Set<TicketStatusDto> statuses;
	private UserEmployeeDto userEmployee;
}
