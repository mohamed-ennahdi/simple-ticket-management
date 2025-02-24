package com.github.mohamedennahdi.simpleticketmanagement.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.UserEmployeeDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.exception.UserEmployeeNotFoundException;
import com.github.mohamedennahdi.simpleticketmanagement.backend.service.UserEmployeeService;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@RestController
@RequestMapping("/users")
public class UserEmployeeController {

	UserEmployeeService employeeService;
	
	@GetMapping( value = "/authenticate" )
	public ResponseEntity<UserEmployeeDto> authenticate(@RequestParam("login") String login, @RequestParam("password") String password) {
		UserEmployeeDto dto;
		try {
			dto = employeeService.authenticate(login, password);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (UserEmployeeNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}
