package com.github.mohamedennahdi.simpleticketmanagement.backend.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;

@DataJpaTest
public class UserEmployeeRepositoryTest {
	
	@Autowired
	UserEmployeeRepository userRepository;
	
	@Test
    public void saveTest() {
		userRepository.save(new UserEmployee());
    }

}
