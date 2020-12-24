package com.login.system.screens;

import com.login.system.beans.Appointment;
import com.login.system.beans.AppointmentView;
import com.login.system.beans.ComboItem;
import com.login.system.beans.Doctor;
import com.login.system.service.AppointmentService;
import com.login.system.service.AppointmentServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewAppointment {

    private JFrame frame;
    private JComboBox doctors;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewAppointment window = new ViewAppointment(args[0]);
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
    public ViewAppointment(String patientId) {
        initialize(patientId);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(String patientId) {
        frame = new JFrame();
        frame.getContentPane().setBackground(UIManager.getColor("Slider.altTrackColor"));
        frame.setBounds(100, 100, 1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel slotLabel = new JLabel("My Appointments");
        slotLabel.setFont(new Font("FreeMono", Font.BOLD, 15));
        slotLabel.setBounds(348, 25, 300, 25);
        frame.getContentPane().add(slotLabel);


        AppointmentService appointmentService = new AppointmentServiceImpl();
        List<AppointmentView> appointmentList =	appointmentService.getAllAppoitntmentForPatient(patientId);

        if(null != appointmentList) {
            int y = 30;
            for (AppointmentView appointment: appointmentList) {
                JLabel appointments = new JLabel();
                appointments.setText(appointment.getDoctorName() + "   ::  " + appointment.getTimeSlot() + "   ::  " + appointment.getStatus());
                appointments.setFont(new Font("FreeSerif", Font.PLAIN, 13));
                y = y + 30;
                appointments.setBounds(290, y, 400, 29);
                frame.getContentPane().add(appointments);

                JButton cancel = new JButton("Cancel");
                cancel.setFont(new Font("FreeSerif", Font.PLAIN, 12));
                cancel.setBounds(600, y, 100, 25);
                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Cancelling the Appointment");
                    }
                });
                frame.getContentPane().add(cancel);
            }
        }

    }



}