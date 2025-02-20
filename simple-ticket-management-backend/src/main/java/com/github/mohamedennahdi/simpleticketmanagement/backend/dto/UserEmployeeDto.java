package com.github.mohamedennahdi.simpleticketmanagement.backend.dto;

import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Role;

import lombok.Data;

@Data
public class UserEmployeeDto {
	private String login;
	private String pwd;
	private Role role;
}
