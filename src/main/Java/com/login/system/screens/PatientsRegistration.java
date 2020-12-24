package com.login.system.screens;

import com.login.system.beans.Patient;
import com.login.system.service.PatientService;
import com.login.system.service.PatientServiceImpl;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class PatientsRegistration {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField passwordField;
	private JTextField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientsRegistration window = new PatientsRegistration();
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
	public PatientsRegistration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("REGISTRATION PAGE");
		frame.getContentPane().setBackground(UIManager.getColor("Slider.altTrackColor"));
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPatientsRegistration = new JLabel("PATIENTS REGISTRATION");
		lblPatientsRegistration.setFont(new Font("FreeMono", Font.BOLD, 26));
		lblPatientsRegistration.setBounds(320, 70, 357, 47);
		frame.getContentPane().add(lblPatientsRegistration);
		
		JLabel label = new JLabel("NAME");
		label.setBounds(233, 182, 66, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("PASSWORD");
		label_1.setBounds(233, 230, 95, 15);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel = new JLabel("EMAIL ID");
		lblNewLabel.setBounds(233, 275, 66, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DOB");
		lblNewLabel_1.setBounds(233, 327, 66, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("GENDER");
		lblNewLabel_2.setBounds(233, 380, 66, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MOBILE NUMBER");
		lblNewLabel_3.setBounds(235, 429, 126, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(417, 180, 200, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(417, 273, 200, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(417, 325, 200, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(417, 427, 200, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setBounds(233, 477, 66, 15);
		frame.getContentPane().add(lblAddress);
		
		textField_6 = new JTextField();
		textField_6.setBounds(417, 475, 200, 19);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		String gender[]= {"Male","Female","Others"};
		JComboBox comboBox = new JComboBox(gender);
		comboBox.setBounds(417, 380, 200, 24);
		frame.getContentPane().add(comboBox);
		
		passwordField = new JTextField();
		passwordField.setText("");
		passwordField.setBounds(417, 230, 200, 19);
		frame.getContentPane().add(passwordField);
		
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Patient patient = new Patient();
				patient.setId(UUID.randomUUID().toString());
				patient.setName(textField.getText());
				patient.setPassword(passwordField.getText());
				patient.setGender(comboBox.getSelectedItem());
				patient.setAddress(textField_6.getText());
				patient.setDob(textField_3.getText());
				patient.setEmail(textField_2.getText());
				patient.setMobileNumber(textField_5.getText());

				PatientService patientService = new PatientServiceImpl();
				try {
					String message = patientService.register(patient);
					JOptionPane.showMessageDialog(frame, message);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "System Error : " + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setBackground(Color.YELLOW);
		btnRegister.setBounds(370, 549, 114, 39);
		frame.getContentPane().add(btnRegister);
		
		
		
	
	}
}