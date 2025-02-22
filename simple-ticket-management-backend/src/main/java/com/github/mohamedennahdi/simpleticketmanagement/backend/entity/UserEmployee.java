package com.github.mohamedennahdi.simpleticketmanagement.backend.entity;

import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String login;
	private String pwd;
	
	@Enumerated(EnumType.STRING)
	private Role role;
}
