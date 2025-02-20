package com.github.mohamedennahdi.simpleticketmanagement.backend.mapper;

import org.mapstruct.Mapper;

import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.UserEmployeeDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;

@Mapper
public interface UserEmployeeMapper extends SimpleTicketManagementMapper<UserEmployeeDto, UserEmployee> {
//	UserEmployee dtoToEntity(UserEmployeeDto userEmployeeDto);
//	UserEmployeeDto entityToDto(UserEmployee userEmployee);
//	
//	List<UserEmployee> dtosToEntities(List<UserEmployeeDto> userEmployeeDtos);
//	List<UserEmployeeDto> entitiesToDtos(List<UserEmployee> userEmployees);
}
