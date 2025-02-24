package com.github.mohamedennahdi.simpleticketmanagement.backend.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;
import com.github.mohamedennahdi.simpleticketmanagement.backend.factory.UserEmployeeFactory;

@DataJpaTest
public class UserEmployeeRepositoryTest {
	
	@Autowired
	UserEmployeeRepository userRepository;
	
	@Test
    public void saveTest() {
		UserEmployee ue = UserEmployeeFactory.make();
		assertNull(ue.getId());
		ue = userRepository.save(ue);
		assertNotNull(ue.getId());
    }

}
