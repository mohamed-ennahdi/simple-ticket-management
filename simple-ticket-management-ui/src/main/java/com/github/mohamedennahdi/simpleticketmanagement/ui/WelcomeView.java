package com.github.mohamedennahdi.simpleticketmanagement.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.TicketDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.UserEmployeeDto;
import com.github.mohamedennahdi.simpleticketmanagement.backend.enums.Role;
import com.github.mohamedennahdi.simpleticketmanagement.ui.client.LocalHTTPClient;

public class WelcomeView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	LocalHTTPClient httpClient = new LocalHTTPClient();
	
	TicketView ticketView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeView frame = new WelcomeView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WelcomeView() {
		getContentPane().setLayout(null);
	}
	
	UserEmployeeDto userEmployeeDto;
	
	public WelcomeView(UserEmployeeDto userEmployeeDto) throws JsonMappingException, JsonProcessingException {
		this.userEmployeeDto = userEmployeeDto;
		ResponseEntity<String> response;
		if (Role.EMPLOYEES.equals(userEmployeeDto.getRole())) {
			Map<String, Object> pathVariables = new HashMap<>();
			pathVariables.put("employeeId", userEmployeeDto.getId());
			response = httpClient.invoke("/tickets/", HttpMethod.GET, new HashMap<String, String>(), pathVariables);
		} else {
			response = httpClient.invoke("/tickets/", HttpMethod.GET, new HashMap<String, String>(), new HashMap<String, Object>());
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		final List<TicketDto> dtos;
		dtos = objectMapper.readValue(response.getBody(), new TypeReference<List<TicketDto>>(){});
		
	    
	    String[] columnNames = { "Id", "Title", "Category", "Status", "Creation Date" };
	    String[][] array = new String[dtos.size()][];
	    for (int i = 0; i < dtos.size(); i++) {
	        List<String> row = new ArrayList<>();
	        TicketDto dto = dtos.get(i);
	        row.add(dto.getId().toString());
	        row.add(dto.getTitle().toString());
	        row.add(dto.getCategory().toString());
	        row.add(dto.getLastStatus().toString());
	        row.add(dto.getCreationDate().toLocaleString());
	        array[i] = row.toArray(new String[row.size()]);
	    }
	    JTable table = new JTable();
	    table.setModel(new DefaultTableModel(array,columnNames));
	    
	    table.setBounds(64, 32, 512, 512);
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel(userEmployeeDto.getLogin());
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserName.setBounds(66, 38, 121, 25);
		contentPane.add(lblUserName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(207, 79, 439, 205);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
//	            System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
	            if (ticketView == null || !ticketView.isVisible()) {
		            ticketView = new TicketView(dtos.get(table.getSelectedRow()));
		            ticketView.setVisible(true);
	            }
	        }
	    });
		
	}
}
