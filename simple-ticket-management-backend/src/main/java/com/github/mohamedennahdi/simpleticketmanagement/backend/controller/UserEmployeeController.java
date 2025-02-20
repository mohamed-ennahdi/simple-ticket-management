package com.github.mohamedennahdi.simpleticketmanagement.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.github.mohamedennahdi.simpleticketmanagement.backend.mapper.UserEmployeeMapper;
import com.github.mohamedennahdi.simpleticketmanagement.backend.service.UserEmployeeService;

import lombok.Data;

@Data
@RestController
public class UserEmployeeController {

	UserEmployeeService employeeService;
	UserEmployeeMapper userEmployeeMapper;
	
	
	
}
