package com.github.mohamedennahdi.simpleticketmanagement.backend.factory;

import java.util.Date;
import java.util.Random;

import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Role;

import net.bytebuddy.utility.RandomString;

public class UserEmployeeFactory {
	
	static Random r = new Random(new Date().getTime());
	
	public static UserEmployee make() {
		
		UserEmployee ue = new UserEmployee();
		ue.setLogin(RandomString.make());
		ue.setPwd(RandomString.make(16));
		ue.setRole(Role.values()[r.nextInt(Role.values().length)]);
		
		return new UserEmployee();
	}
}
