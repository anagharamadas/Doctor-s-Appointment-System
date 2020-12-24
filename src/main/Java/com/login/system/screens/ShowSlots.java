package com.login.system.screens;

import com.login.system.beans.Appointment;
import com.login.system.beans.ComboItem;
import com.login.system.beans.Doctor;
import com.login.system.beans.Slot;
import com.login.system.service.AppointmentService;
import com.login.system.service.AppointmentServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;

public class ShowSlots {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShowSlots window = new ShowSlots(args[0], args[1]);
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
    public ShowSlots(String doctorId, String patientId) {
        initialize(doctorId, patientId);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(String doctorId, String patientId) {
        frame = new JFrame();
        frame.getContentPane().setBackground(UIManager.getColor("Slider.altTrackColor"));
        frame.setBounds(100, 100, 1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel label = new JLabel("Available Slots");
        label.setFont(new Font("FreeMono", Font.BOLD, 26));
        label.setBounds(348, 45, 333, 47);
        frame.getContentPane().add(label);

        AppointmentService appointmentService1 = new AppointmentServiceImpl();
        try {
            List<Slot> slots = appointmentService1.getAllSlotsForDoctor(doctorId);
            if (slots != null) {
                int y = 179;
                for (Slot slot : slots) {

                    if (slot.getBooked()) {
                        JLabel button = new JLabel("Booked");
                        button.setForeground(Color.GRAY);
                        y = y + 30;
                        button.setBounds(240, y, 170, 25);
                        frame.getContentPane().add(button);
                    } else {
                        JButton button = new JButton("Book");
                        button.setBackground(Color.YELLOW);
                        y = y + 30;
                        button.setBounds(200, y, 170, 25);
                        button.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Appointment appointment = new Appointment();
                                appointment.setSlotId(slot.getId());
                                appointment.setId(UUID.randomUUID().toString());
                                appointment.setPatientId(patientId);
                                appointment.setDoctorId(doctorId);
                                String message = appointmentService1.createAppointment(appointment);
                                JOptionPane.showMessageDialog(frame, message);
                            }
                        });
                        frame.getContentPane().add(button);
                    }
                    JLabel slotLabel = new JLabel(slot.getTimeSlot());
                    slotLabel.setForeground(Color.darkGray);
                    slotLabel.setFont(new Font("FreeMono", Font.BOLD, 15));
                    slotLabel.setBounds(400, y, 300, 25);
                    frame.getContentPane().add(slotLabel);
                }

            } else {
                frame.getContentPane().add(new JLabel("No Slots Available for This Doctor. Please close this window and Select Another Doctor"));
            }


        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "System Error : " + ex.getMessage());
            ex.printStackTrace();
        }

    }


}