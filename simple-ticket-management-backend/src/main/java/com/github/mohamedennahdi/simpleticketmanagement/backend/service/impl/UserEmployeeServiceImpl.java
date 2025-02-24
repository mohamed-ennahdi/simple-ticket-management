package com.github.mohamedennahdi.simpleticketmanagement.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.UserEmployeeDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;
import com.github.mohamedennahdi.simpleticketmanagement.backend.exception.UserEmployeeNotFoundException;
import com.github.mohamedennahdi.simpleticketmanagement.backend.mapper.UserEmployeeMapper;
import com.github.mohamedennahdi.simpleticketmanagement.backend.repository.UserEmployeeRepository;
import com.github.mohamedennahdi.simpleticketmanagement.backend.service.UserEmployeeService;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Service
public class UserEmployeeServiceImpl implements UserEmployeeService {
	private UserEmployeeRepository userEmployeeRepository;
	private UserEmployeeMapper userEmployeeMapper;
	
	public List<UserEmployeeDto> findAll() {
		 return userEmployeeMapper.entitiesToDtos(userEmployeeRepository.findAll());
	}
	
	public UserEmployeeDto findById(Long id) throws UserEmployeeNotFoundException {
		UserEmployee ue = userEmployeeRepository.findById(id).orElseThrow(() -> new UserEmployeeNotFoundException());
		return userEmployeeMapper.entityToDto(ue);
	}

	@Override
	public UserEmployeeDto authenticate(String login, String password) throws UserEmployeeNotFoundException {
		UserEmployee ue = userEmployeeRepository.findByLoginAndPwd(login, password).orElseThrow(() -> new UserEmployeeNotFoundException());
		return userEmployeeMapper.entityToDto(ue);
	}
}
