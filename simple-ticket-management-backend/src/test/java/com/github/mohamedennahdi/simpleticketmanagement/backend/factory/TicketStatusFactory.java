package com.github.mohamedennahdi.simpleticketmanagement.backend.factory;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.TicketStatus;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Category;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Priority;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Status;

import net.bytebuddy.utility.RandomString;

public class TicketStatusFactory {
	
	static Random r = new Random(new Date().getTime());
	
	public static TicketStatus make(Ticket ticket) {
		TicketStatus ts = new TicketStatus();
		
//		t.setCategory(Category.values()[r.nextInt(Category.values().length)]);
//		t.setPriority(Priority.values()[r.nextInt(Priority.values().length)]);
//		t.setCreationDate(new java.sql.Date(new Date().getTime() - r.nextInt(128)));
//		t.setDescription(RandomString.make(128));
//		t.setTitle(RandomString.make(16));
		
		ts.setAssignmentDate(new java.sql.Date(ThreadLocalRandom.current().nextLong()));
		ts.setStatus(Status.values()[r.nextInt(Status.values().length)]);
		ts.setTicket(ticket);
		
		return ts;
	}
}
