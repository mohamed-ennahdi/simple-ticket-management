package com.github.mohamedennahdi.simpleticketmanagement.backend.mapper;

import java.util.List;

public interface SimpleTicketManagementMapper<DTO, ENT> {
	ENT dtoToEntity(DTO dto);
	DTO entityToDto(ENT entity);
	
	List<ENT> dtosToEntities(List<DTO> dtos);
	List<DTO> entitiesToDtos(List<ENT> entities);
}
