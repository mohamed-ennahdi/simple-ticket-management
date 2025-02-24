package com.github.mohamedennahdi.simpleticketmanagement.ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.TicketDto;

public class TicketView extends JFrame {
	
//	private TicketDto ticketDto;
	private JLabel lblUserName;

	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtPriority;
	private JTextField txtCategorie;
	private JTextField txtStatus;
	JTextArea txtDescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketView frame = new TicketView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TicketView() {
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(115, 94, 127, 31);
		getContentPane().add(lblTitle);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDescription.setBounds(115, 230, 127, 31);
		getContentPane().add(lblDescription);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPriority.setBounds(115, 135, 127, 31);
		getContentPane().add(lblPriority);
		
		lblUserName = new JLabel("<User Name>");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserName.setBounds(115, 10, 207, 31);
		getContentPane().add(lblUserName);
		
		txtTitle = new JTextField();
		txtTitle.setEditable(false);
		txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTitle.setBounds(252, 94, 318, 29);
		getContentPane().add(txtTitle);
		txtTitle.setColumns(10);
		
		txtPriority = new JTextField();
		txtPriority.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPriority.setEditable(false);
		txtPriority.setColumns(10);
		txtPriority.setBounds(252, 135, 318, 29);
		getContentPane().add(txtPriority);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCategorie.setBounds(115, 167, 127, 31);
		getContentPane().add(lblCategorie);
		
		txtCategorie = new JTextField();
		txtCategorie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCategorie.setEditable(false);
		txtCategorie.setColumns(10);
		txtCategorie.setBounds(252, 172, 318, 29);
		getContentPane().add(txtCategorie);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStatus.setBounds(580, 50, 127, 31);
		getContentPane().add(lblStatus);
		
		txtStatus = new JTextField();
		txtStatus.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtStatus.setEditable(false);
		txtStatus.setColumns(10);
		txtStatus.setBounds(580, 94, 318, 29);
		getContentPane().add(txtStatus);
		
		txtDescription = new JTextArea();
		txtDescription.setEditable(false);
		txtDescription.setBounds(115, 271, 785, 155);
		getContentPane().add(txtDescription);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Create the frame.
	 */
	public TicketView(String username, TicketDto ticketDto) {
		this();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(128, 64, 1024, 512);
		
		this.lblUserName.setText(username);
		
		this.txtTitle.setText(ticketDto.getTitle());
		this.txtDescription.setText(ticketDto.getDescription());
		this.txtCategorie.setText(ticketDto.getCategory().name());
		this.txtPriority.setText(ticketDto.getPriority().name());
		this.txtStatus.setText(ticketDto.getLastStatus().getStatus().name());
	}
}
