package com.github.mohamedennahdi.simpleticketmanagement.backend.factory;

import java.util.Date;
import java.util.Random;
import java.util.Set;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.TicketStatus;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Category;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Priority;

import net.bytebuddy.utility.RandomString;

public class TicketFactory {
	
	static Random r = new Random(new Date().getTime());
	
	public static Ticket make() {
		Ticket t = new Ticket();
		
		t.setCategory(Category.values()[r.nextInt(Category.values().length)]);
		t.setPriority(Priority.values()[r.nextInt(Priority.values().length)]);
		t.setCreationDate(new java.sql.Date(new Date().getTime() - r.nextInt(128)));
		t.setDescription(RandomString.make(128));
		t.setTitle(RandomString.make(16));
		
		return t;
	}
	
	public static Ticket make(Set<TicketStatus> ticketStatuses) {
		Ticket t = make();
		
		t.setStatuses(ticketStatuses);
		return t;
	}
	
	public static Ticket make(UserEmployee ue) {
		Ticket t = make();
		t.setUserEmployee(ue);
		
		return t;
	}
}
