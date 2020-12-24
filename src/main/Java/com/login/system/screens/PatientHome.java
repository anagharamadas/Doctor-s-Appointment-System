package com.login.system.screens;

import com.login.system.beans.Appointment;
import com.login.system.service.AppointmentService;
import com.login.system.service.AppointmentServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PatientHome {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientHome window = new PatientHome(args[0], args[1]);
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
	public PatientHome(String name, String patientId) {
		initialize(name, patientId);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, String patientId) {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Slider.altTrackColor"));
		frame.setBounds(100, 100, 1000, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel txtpnViewDoctorsBooking = new JLabel();
		txtpnViewDoctorsBooking.setText("Welcome " + name + " :)");
		txtpnViewDoctorsBooking.setFont(new Font("FreeSerif", Font.PLAIN, 24));
		txtpnViewDoctorsBooking.setBounds(290, 10, 538, 47);
		frame.getContentPane().add(txtpnViewDoctorsBooking);

		JButton bookAppointment = new JButton("Book Appointment");
		bookAppointment.setBackground(Color.YELLOW);
		bookAppointment.setBounds(200, 179, 170, 30);

		bookAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BookAppointment.main(new String[]{patientId});
			}});
		frame.getContentPane().add(bookAppointment);

		JButton viewAppointments = new JButton("View Appointment");
		viewAppointments.setBackground(Color.YELLOW);
		viewAppointments.setBounds(400, 179, 170, 30);

		viewAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ViewAppointment.main(new String[]{patientId});
			}});
		frame.getContentPane().add(viewAppointments);

	}
}