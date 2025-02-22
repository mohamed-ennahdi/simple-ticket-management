package com.github.mohamedennahdi.simpleticketmanagement.backend.service;

import java.util.List;

import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.UserEmployeeDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.exception.UserEmployeeNotFoundException;

public interface UserEmployeeService {
	List<UserEmployeeDto> findAll();
	UserEmployeeDto findById(Long id) throws UserEmployeeNotFoundException;
	UserEmployeeDto authenticate(String login, String password) throws UserEmployeeNotFoundException;
}
