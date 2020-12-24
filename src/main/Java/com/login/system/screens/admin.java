



package com.login.system.screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTextPane;

public class admin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin window = new admin();
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
	public admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("ADMIN PROFILE");
		frame.getContentPane().setBackground(UIManager.getColor("Slider.altTrackColor"));
		frame.setBounds(200, 200, 950, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDoctorAppointment = new JLabel("DOCTOR APPOINTMENT");
		lblDoctorAppointment.setFont(new Font("FreeMono", Font.BOLD, 26));
		lblDoctorAppointment.setBounds(288, 21, 311, 44);
		frame.getContentPane().add(lblDoctorAppointment);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(288, 63, 301, 2);
		frame.getContentPane().add(separator);
		
		JButton btnHome = new JButton("HOME");
		btnHome.setBackground(Color.YELLOW);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				front info=new front();
				front.main(null);
			}
		});
		btnHome.setBounds(24, 101, 108, 35);
		frame.getContentPane().add(btnHome);
		
		JButton btnViewDoctors = new JButton("VIEW DOCTORS");
		btnViewDoctors.setBackground(Color.YELLOW);
		btnViewDoctors.setBounds(165, 101, 137, 35);
		frame.getContentPane().add(btnViewDoctors);
		
		JButton btnViewPatients = new JButton("VIEW PATIENTS");
		btnViewPatients.setBackground(Color.YELLOW);
		btnViewPatients.setBounds(330, 101, 137, 35);
		frame.getContentPane().add(btnViewPatients);
		
		JButton btnPatientsReq = new JButton("PATIENTS REQ");
		btnPatientsReq.setBackground(Color.YELLOW);
		btnPatientsReq.setBounds(499, 101, 146, 35);
		frame.getContentPane().add(btnPatientsReq);
		
		JButton btnDoctorsReq = new JButton("DOCTORS REQ");
		btnDoctorsReq.setBackground(Color.YELLOW);
		btnDoctorsReq.setBounds(665, 101, 146, 35);
		frame.getContentPane().add(btnDoctorsReq);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setBackground(Color.YELLOW);
		btnLogout.setBounds(839, 101, 99, 35);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/user/Desktop/images.png"));
		lblNewLabel.setBounds(340, 110, 298, 176);
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane txtpnWelcomeAdmin = new JTextPane();
		txtpnWelcomeAdmin.setBackground(UIManager.getColor("ProgressBar.selectionForeground"));
		txtpnWelcomeAdmin.setFont(new Font("Bitstream Charter", Font.BOLD, 26));
		txtpnWelcomeAdmin.setText("            WELCOME ADMIN");
		txtpnWelcomeAdmin.setBounds(290, 286, 433, 44);
		frame.getContentPane().add(txtpnWelcomeAdmin);
	}

}