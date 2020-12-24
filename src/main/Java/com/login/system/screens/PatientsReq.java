package com.login.system.screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class PatientsReq {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientsReq window = new PatientsReq();
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
	public PatientsReq() {
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
		
		JLabel label = new JLabel("DOCTOR APPOINTMENT");
		label.setFont(new Font("FreeMono", Font.BOLD, 26));
		label.setBounds(326, 70, 333, 25);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("HOME");
		button.setBackground(Color.YELLOW);
		button.setBounds(143, 167, 114, 25);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				front info= new front();
				front.main(null);
			}});
		frame.getContentPane().add(button);
		
		
		
		JButton button_5 = new JButton("LOGOUT");
		button_5.setBackground(Color.YELLOW);
		button_5.setBounds(767, 167, 114, 25);
		frame.getContentPane().add(button_5);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("/home/user/Desktop/images.png"));
		label_1.setBounds(367, 306, 376, 207);
		frame.getContentPane().add(label_1);
		
		JLabel lblPatientIllness = new JLabel("Patient illness");
		lblPatientIllness.setBounds(153, 263, 123, 42);
		frame.getContentPane().add(lblPatientIllness);
		
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		frame.getContentPane().add(table);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(153, 333, 104, 42);
		frame.getContentPane().add(lblDoctor);
		String patient[]= {"Fever","Headache","Migrain"};
		JComboBox comboBox = new JComboBox(patient);
		comboBox.setBounds(274, 272, 250, 24);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(275, 342, 249, 24);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblDate = new JLabel("Date : ");
		lblDate.setBounds(153, 471, 87, 42);
		frame.getContentPane().add(lblDate);
		
		JLabel lblTime = new JLabel("Time : ");
		lblTime.setBounds(540, 483, 69, 18);
		frame.getContentPane().add(lblTime);
		
		
	}
}