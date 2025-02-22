package com.github.mohamedennahdi.simpleticketmanagement.ui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Properties properties = new Properties();
	
	JTextPane textPaneLogin = new JTextPane();
	JTextPane textPanePassword = new JTextPane();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
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
					!StringUtils.hasText(textPanePassword.getText())) {
					JOptionPane.showMessageDialog(null, "Login and Password are required");
					return;
				}
				
				String url = properties.getProperty("simple.ticket.management.backend");
				
				Map<String, String> params = new HashMap<>();
				params.put("login", textPaneLogin.getText());
				params.put("password", textPanePassword.getText());

				
				
				RestTemplate restTemplate = new RestTemplate();
				String fooResourceUrl = url + "/users/authenticate";
				
				UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(fooResourceUrl)
						// Add query parameter
						.queryParam("login", textPaneLogin.getText())
						.queryParam("password", textPanePassword.getText());
//				ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class, vars);
				
				HttpHeaders headers = new HttpHeaders();
				headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
				HttpEntity<?> entity = new HttpEntity<>(headers);
				try {
					ResponseEntity<String> response = restTemplate.exchange(
							builder.toUriString(),
					        HttpMethod.GET,
					        entity,
					        String.class
					);
					System.out.println(response);
				} catch (HttpClientErrorException ex) {
//					ex.printStackTrace();
					System.out.println(ex.getMessage());
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
				
			}
		});
		btnLogin.setBounds(151, 185, 104, 25);
		contentPane.add(btnLogin);
		
		textPaneLogin.setBounds(174, 61, 127, 35);
		contentPane.add(textPaneLogin);
		
		textPanePassword.setBounds(174, 123, 127, 31);
		contentPane.add(textPanePassword);
		
		try (InputStream is = getClass().getClassLoader().getResourceAsStream("application.properties")) {
		  properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
