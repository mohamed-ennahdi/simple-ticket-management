package com.github.mohamedennahdi.simpleticketmanagement.backend.mapper;

import org.mapstruct.Mapper;

import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.TicketDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;

@Mapper(componentModel = "spring")
public interface TicketMapper extends SimpleTicketManagementMapper<TicketDto, Ticket> {
	
}
