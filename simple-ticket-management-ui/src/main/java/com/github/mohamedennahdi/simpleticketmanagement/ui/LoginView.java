package com.github.mohamedennahdi.simpleticketmanagement.ui;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.UserEmployeeDto;
import com.github.mohamedennahdi.simpleticketmanagement.ui.client.LocalHTTPClient;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Properties properties = new Properties();
	
	JTextPane textPaneLogin = new JTextPane();
	private JPasswordField passwordField;
	
	private WelcomeView welcome;
	
	LocalHTTPClient httpClient = new LocalHTTPClient();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(50, 61, 114, 25);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(50, 119, 156, 35);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (!StringUtils.hasText(textPaneLogin.getText())
					||
					!StringUtils.hasText(String.valueOf(passwordField.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Login and Password are required");
					return;
				}
				
				Map<String, String> requestParams = new HashMap<>();
				requestParams.put("login", textPaneLogin.getText().trim());
				requestParams.put("password", String.valueOf(passwordField.getPassword()).trim());
				
				try {
					ResponseEntity<String> response = httpClient.invoke("/users/authenticate", HttpMethod.GET, requestParams, new HashMap<String, Object>());
					
					ObjectMapper objectMapper = new ObjectMapper();
				    UserEmployeeDto dto = objectMapper.readValue(response.getBody(), UserEmployeeDto.class);
				    welcome = new WelcomeView(dto);
					welcome.setVisible(true);
					setVisible(false);
				} catch (HttpClientErrorException | JsonProcessingException ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		btnLogin.setBounds(151, 185, 104, 25);
		contentPane.add(btnLogin);
		textPaneLogin.setText("user1");
		
		textPaneLogin.setBounds(174, 61, 149, 25);
		contentPane.add(textPaneLogin);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(174, 127, 149, 25);
		contentPane.add(passwordField);
		
//		try (InputStream is = getClass().getClassLoader().getResourceAsStream("application.properties")) {
//		  properties.load(is);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
}
