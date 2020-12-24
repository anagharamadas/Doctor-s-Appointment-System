package com.login.system.screens;

import com.login.system.beans.Patient;
import com.login.system.service.ConnectionUtil;
import com.login.system.service.PatientService;
import com.login.system.service.PatientServiceImpl;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientLogin {

	private JFrame frame;
	private JTextField textField;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientLogin window = new PatientLogin();
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
	public PatientLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("PATIENT LOGIN PAGE");
		JOptionPane.showMessageDialog(frame,  ConnectionUtil.checkConnectionOnStartUp());
		frame.getContentPane().setBackground(UIManager.getColor("Slider.altTrackColor"));
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Patient Login");
		label.setFont(new Font("FreeMono", Font.BOLD, 26));
		label.setBounds(296, 51, 333, 47);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("/home/user/Desktop/images.png"));
		label_1.setBounds(314, 170, 324, 147);
		frame.getContentPane().add(label_1);
		
		JLabel lblPatientsName = new JLabel("Name");
		lblPatientsName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPatientsName.setBounds(257, 486, 130, 15);
		frame.getContentPane().add(lblPatientsName);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setFont(new Font("Dialog", Font.BOLD, 14));
		label_3.setBounds(257, 542, 107, 15);
		frame.getContentPane().add(label_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(463, 484, 216, 25);
		frame.getContentPane().add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(463, 540, 216, 25);
		frame.getContentPane().add(passwordField);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PatientService patientService = new PatientServiceImpl();
				try {
					Patient patient = patientService.login(textField.getText(), passwordField.getText());
					if (null != patient) {
						JOptionPane.showMessageDialog(frame, "Welcome User, " + patient.getName());
						PatientHome.main(new String[]{
								patient.getName(), patient.getId()
						});
					} else {
						JOptionPane.showMessageDialog(frame, "Invalid Credentials, Please Try to Register");
					}

				} catch (Exception er){
					JOptionPane.showMessageDialog(frame, "System Error : " + er.getMessage());
					er.printStackTrace();
				}

			}
		});
		button.setBackground(Color.YELLOW);
		button.setBounds(257, 627, 114, 32);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("REGISTER");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PatientsRegistration info= new PatientsRegistration();
				PatientsRegistration.main(null);
				
				
			}
		});
		button_1.setFont(new Font("FreeSerif", Font.BOLD, 12));
		button_1.setBackground(Color.ORANGE);
		button_1.setBounds(542, 631, 137, 32);
		frame.getContentPane().add(button_1);
	}
}