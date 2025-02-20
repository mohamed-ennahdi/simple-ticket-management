package com.github.mohamedennahdi.simpleticketmanagement.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;
import com.github.mohamedennahdi.simpleticketmanagement.backend.mapper.UserEmployeeMapper;
import com.github.mohamedennahdi.simpleticketmanagement.backend.repository.UserEmployeeRepository;
import com.github.mohamedennahdi.simpleticketmanagement.backend.service.UserEmployeeService;

import lombok.Data;

@Data
@Service
public class UserEmployeeServiceImpl implements UserEmployeeService {
	private UserEmployeeRepository userEmployeeRepository;
	private UserEmployeeMapper userEmployeeMapper;
	
	public List<UserEmployee> findAll() {
		 return userEmployeeRepository.findAll();
	}
	
	public Optional<UserEmployee> findById(Long id) {
		return userEmployeeRepository.findById(id);
	}
}
