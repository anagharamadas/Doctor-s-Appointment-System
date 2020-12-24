package com.login.system.screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JTextPane;

public class front {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					front window = new front();
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
	public front() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("HOME");
		frame.getContentPane().setForeground(Color.RED);
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.setBounds(200, 200, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDoctorAppointment = new JLabel("DOCTOR APPOINTMENT");
		lblDoctorAppointment.setBounds(137, 24, 295, 58);
		lblDoctorAppointment.setBackground(Color.BLACK);
		lblDoctorAppointment.setFont(new Font("FreeMono", Font.BOLD, 25));
		frame.getContentPane().add(lblDoctorAppointment);
		
		
		
		
		JButton btnDoctor = new JButton("DOCTOR");
		btnDoctor.setBounds(100, 104, 106, 35);
		btnDoctor.setFont(new Font("FreeSans", Font.BOLD, 14));
		btnDoctor.setForeground(Color.BLACK);
		btnDoctor.setBackground(Color.YELLOW);
		btnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DoctorLogin	 info= new DoctorLogin();
				DoctorLogin.main(null);
			}});
				
		frame.getContentPane().add(btnDoctor);
		
		JButton btnPatient = new JButton("PATIENT");
		btnPatient.setBounds(400, 104, 114, 35);
		btnPatient.setBackground(Color.YELLOW);
		btnPatient.setFont(new Font("FreeSans", Font.BOLD, 14));
		btnPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientLogin info= new PatientLogin();
				PatientLogin.main(null);
			}});
				
		frame.getContentPane().add(btnPatient);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(137, 67, 295, 15);
		frame.getContentPane().add(separator);
		
		
		
		JTextPane txtpn = new JTextPane();
		txtpn.setBackground(new Color(238, 238, 238));
		txtpn.setFont(new Font("Bitstream Charter", Font.PLAIN, 21));
		txtpn.setText("WELCOME TO ONLINE DOCTOR APPOINTMENT");
		txtpn.setBounds(46, 282, 493, 51);
		frame.getContentPane().add(txtpn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(UIManager.getColor("Checkbox.select"));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(12, 78, 576, 180);
		frame.getContentPane().add(lblNewLabel);
	}
}