package com.github.mohamedennahdi.simpleticketmanagement.backend.mapper;

import org.mapstruct.Mapper;

import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.UserEmployeeDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;

@Mapper(componentModel = "spring")
public interface UserEmployeeMapper extends SimpleTicketManagementMapper<UserEmployeeDto, UserEmployee> {
}
