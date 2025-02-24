package com.github.mohamedennahdi.simpleticketmanagement.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;

public interface UserEmployeeRepository extends JpaRepository<UserEmployee, Long> {
	Optional<UserEmployee> findByLoginAndPwd(String login, String password);
}
