package com.github.mohamedennahdi.simpleticketmanagement.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.mohamedennahdi.simpleticketmanagement.backend.dto.TicketDto;

public class TicketView extends JFrame {
	
	TicketDto ticketDto;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Create the frame.
	 */
	public TicketView(TicketDto ticketDto) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		this.ticketDto = ticketDto;
	}

}
