package com.github.mohamedennahdi.simpleticketmanagement.backend.service;

import java.util.List;
import java.util.Optional;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;

public interface UserEmployeeService {
	List<UserEmployee> findAll();
	Optional<UserEmployee> findById(Long id);
}
