package com.github.mohamedennahdi.simpleticketmanagement.backend.factory;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.TicketStatus;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Status;

public class TicketStatusFactory {
	
	static Random r = new Random(new Date().getTime());
	
	public static TicketStatus make() {
		TicketStatus ts = new TicketStatus();
		
		ts.setAssignmentDate(LocalDateTime.now());
		ts.setStatus(Status.values()[r.nextInt(Status.values().length)]);
		
		return ts;
	}
}
