package com.github.mohamedennahdi.simpleticketmanagement.backend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.TicketDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.UserEmployeeDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.Ticket;
import com.github.mohamedennahdi.simpleticketmanagement.backend.entity.UserEmployee;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Category;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Priority;
import com.github.mohamedennahdi.simpleticketmanagement.backend.factory.TicketFactory;
import com.github.mohamedennahdi.simpleticketmanagement.backend.factory.UserEmployeeFactory;
import com.github.mohamedennahdi.simpleticketmanagement.backend.repository.TicketRepository;
import com.github.mohamedennahdi.simpleticketmanagement.backend.repository.UserEmployeeRepository;

import jakarta.annotation.Generated;

@Generated(value = "org.junit-tools-1.1.0")
@SpringBootTest
@AutoConfigureMockMvc
public class TicketControllerTest {
	
    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private UserEmployeeRepository employeeRepository;
    
    @Autowired
    private TicketRepository ticketRepository;
    
    private UserEmployee u;
    
    private ObjectMapper objectMapper = new ObjectMapper();
    
    @BeforeEach
    void init() {
    	u = UserEmployeeFactory.make();
    	u = employeeRepository.save(u);
    	List<Ticket> tickets = new ArrayList<Ticket>();
    	tickets.add(TicketFactory.make(u));
    	tickets.add(TicketFactory.make(u));
    	tickets.add(TicketFactory.make(u));
    	tickets.add(TicketFactory.make(u));
    	tickets.add(TicketFactory.make(u));
    	
    	UserEmployee u1 = UserEmployeeFactory.make();
    	u1 = employeeRepository.save(u1);
    	
    	tickets.add(TicketFactory.make(u1));
    	tickets.add(TicketFactory.make(u1));
    	tickets.add(TicketFactory.make(u1));
    	tickets.add(TicketFactory.make(u1));
    	tickets.add(TicketFactory.make(u1));
    	
    	ticketRepository.saveAll(tickets);
    }


	@Test
	void createTicketTest() throws Exception {
		UserEmployeeDto udto = new UserEmployeeDto();
		udto.setId(u.getId());
		
		TicketDto dto = new TicketDto(1L, "", "", Priority.HIGH, Category.HARDWARE, null, null, null, udto);
		String json = objectMapper.writeValueAsString(dto);
		mvc.perform(MockMvcRequestBuilders.post("/tickets/")
			      						  .content(json)
			      						  .contentType(MediaType.APPLICATION_JSON)
			      						  .accept(MediaType.APPLICATION_JSON))
		   .andExpect(MockMvcResultMatchers.status()
				   						   .isCreated());
	}
	
	@Test
	void getAllTicketsTest() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/tickets/")
				  						  					 .contentType(MediaType.APPLICATION_JSON)
				  						  					 .accept(MediaType.APPLICATION_JSON))
							  .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		
		String json = result.getResponse().getContentAsString();
	    List<TicketDto> tickets = objectMapper.readValue(json, new TypeReference<>(){});

	    assertNotNull(tickets);
	    assertEquals(10, tickets.size());
	}
	
	@Test
	void getTicketsByEmployeeTest() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/tickets/{employeeId}", u.getId())
															 .contentType(MediaType.APPLICATION_JSON)
															 .accept(MediaType.APPLICATION_JSON))
							  .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		
		String json = result.getResponse().getContentAsString();
		List<TicketDto> tickets = objectMapper.readValue(json, new TypeReference<>(){});
		
		assertNotNull(tickets);
		assertEquals(5, tickets.size());
	}
}