package com.github.mohamedennahdi.simpleticketmanagement.backend.factory;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Comment;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;

import net.bytebuddy.utility.RandomString;

public class CommentFactory {
	public static Comment make(Ticket ticket) {
		Comment comment = new Comment();
		
		comment.setText(RandomString.make());
		comment.setTicket(ticket);
		
		return comment;
	}
}
