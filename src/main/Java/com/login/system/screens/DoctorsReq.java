package com.login.system.screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTable;

public class DoctorsReq {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorsReq window = new DoctorsReq();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DoctorsReq() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Slider.altTrackColor"));
		frame.setBounds(100, 100, 1000, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnViewDoctorsBooking = new JTextPane();
		txtpnViewDoctorsBooking.setText("            VIEW DOCTORS BOOKING REQUEST");
		txtpnViewDoctorsBooking.setFont(new Font("FreeSerif", Font.PLAIN, 24));
		txtpnViewDoctorsBooking.setBounds(254, 463, 538, 47);
		frame.getContentPane().add(txtpnViewDoctorsBooking);
		
		JLabel label = new JLabel("DOCTOR APPOINTMENT");
		label.setFont(new Font("FreeMono", Font.BOLD, 26));
		label.setBounds(364, 73, 333, 47);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("HOME");
		button.setBackground(Color.YELLOW);
		button.setBounds(40, 179, 114, 25);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				front info= new front();
				front.main(null);
			}});
		frame.getContentPane().add(button);		
		
		
		
		JButton button_2 = new JButton("VIEW PATIENTS");
		button_2.setBackground(Color.YELLOW);
		button_2.setBounds(350, 179, 137, 25);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("PATIENTS REQ");
		button_3.setBackground(Color.YELLOW);
		button_3.setBounds(530, 179, 137, 25);
		frame.getContentPane().add(button_3);
		
		
		
		JButton button_5 = new JButton("LOGOUT");
		button_5.setBackground(Color.YELLOW);
		button_5.setBounds(874, 179, 114, 25);
		frame.getContentPane().add(button_5);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("/home/user/Desktop/images.png"));
		label_1.setBounds(354, 253, 313, 164);
		frame.getContentPane().add(label_1);
		
		table = new JTable();
		table.setBounds(110, 568, 822, 124);
		frame.getContentPane().add(table);
	}
}