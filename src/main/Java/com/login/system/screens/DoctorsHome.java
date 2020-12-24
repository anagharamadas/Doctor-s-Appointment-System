package com.login.system.screens;

import com.login.system.beans.BookedAppointmentView;
import com.login.system.service.AppointmentService;
import com.login.system.service.AppointmentServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DoctorsHome {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorsHome window = new DoctorsHome(args[1]);
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
	public DoctorsHome(String doctorId) {
		initialize(doctorId);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String doctorId) {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Slider.altTrackColor"));
		frame.setBounds(100, 100, 1000, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Confirmed Appointments With Patients");
		label.setFont(new Font("FreeMono", Font.BOLD, 17));
		label.setForeground(Color.LIGHT_GRAY);
		label.setBounds(364, 73, 400, 47);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("/home/user/Desktop/images.png"));
		label_1.setBounds(354, 253, 313, 164);
		frame.getContentPane().add(label_1);

		AppointmentService appointmentService = new AppointmentServiceImpl();
		List<BookedAppointmentView> bookedAppointmentViewList =	appointmentService.getAllAppoitntmentForDoctor(doctorId);
		if (null != bookedAppointmentViewList) {
			int y = 100;
			int count = 0;
			for (BookedAppointmentView bookedAppointmentView :bookedAppointmentViewList) {
				count = count + 1;
				JLabel app = new JLabel(count + "." +bookedAppointmentView.getPatientDetail() + " " +bookedAppointmentView.getTimeSlot() + "  " + bookedAppointmentView.getStatus());
				app.setIcon(new ImageIcon("/home/user/Desktop/images.png"));
				y = y + 30;
				app.setBounds(20, y, 500, 164);
				frame.getContentPane().add(app);
			}
		}
	}
}