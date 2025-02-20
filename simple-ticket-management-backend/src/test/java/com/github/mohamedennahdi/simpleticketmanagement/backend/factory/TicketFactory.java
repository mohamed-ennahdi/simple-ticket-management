package com.github.mohamedennahdi.simpleticketmanagement.backend.factory;

import java.util.Date;
import java.util.Random;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;
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
}
