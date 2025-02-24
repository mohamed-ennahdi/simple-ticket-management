package com.github.mohamedennahdi.simpleticketmanagement.backend.dto;

import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Role;

import lombok.Data;

@Data
public class UserEmployeeDto {
	private Long id;
	private String login;
	private Role role;
}
