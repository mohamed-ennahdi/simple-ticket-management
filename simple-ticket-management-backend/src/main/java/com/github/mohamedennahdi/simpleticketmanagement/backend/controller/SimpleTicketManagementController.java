package com.github.mohamedennahdi.simpleticketmanagement.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class SimpleTicketManagementController {
	@GetMapping( value = "/html" )
	public ResponseEntity<String> test(@Parameter(name = "test") @RequestParam String test) {
		return new ResponseEntity<>("Test", HttpStatus.OK);
	}
}
