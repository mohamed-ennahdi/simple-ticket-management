package com.github.mohamedennahdi.simpleticketmanagement.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;

public interface UserEmployeeRepository extends JpaRepository<UserEmployee, Long> {

}
