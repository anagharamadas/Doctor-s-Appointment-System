package com.login.system.screens;

import com.login.system.beans.Doctor;
import com.login.system.beans.Slot;
import com.login.system.service.AppointmentService;
import com.login.system.service.AppointmentServiceImpl;
import com.login.system.service.DoctorService;
import com.login.system.service.DoctorServiceImpl;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DoctorRegistration {

    private JFrame frame;
    private JTextField name;
    private JTextField phone;
    private JTextField location1;
    private JTextField eid;
    private JTextField spec;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField pass;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DoctorRegistration window = new DoctorRegistration();
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
    public DoctorRegistration() {
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

        JLabel lblDoctorRegistration = new JLabel("DOCTOR REGISTRATION");
        lblDoctorRegistration.setFont(new Font("FreeMono", Font.BOLD, 26));
        lblDoctorRegistration.setBounds(301, 56, 333, 47);
        frame.getContentPane().add(lblDoctorRegistration);

        JLabel lblNewLabel = new JLabel("NAME");
        lblNewLabel.setBounds(194, 152, 66, 15);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("PASSWORD");
        lblNewLabel_1.setBounds(194, 199, 95, 15);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("LOCATION");
        lblNewLabel_2.setBounds(194, 251, 81, 15);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblSelectGender = new JLabel("SELECT GENDER");
        lblSelectGender.setBounds(194, 297, 118, 15);
        frame.getContentPane().add(lblSelectGender);

        JLabel lblNewLabel_3 = new JLabel("EMAIL ID");
        lblNewLabel_3.setBounds(194, 347, 66, 15);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("TIMING / SLOTS");
        lblNewLabel_4.setBounds(194, 440, 66, 15);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("CATEGORY");
        lblNewLabel_5.setBounds(194, 391, 95, 15);
        frame.getContentPane().add(lblNewLabel_5);

        JLabel lblMobileNumber = new JLabel("MOBILE NUMBER");
        lblMobileNumber.setBounds(194, 491, 118, 15);
        frame.getContentPane().add(lblMobileNumber);
        String gender[] = {"Male","Female", "Others"};
        JComboBox comboBox1 = new JComboBox(gender);
        comboBox1.setBounds(408, 288, 192, 24);
        frame.getContentPane().add(comboBox1);

        name = new JTextField();
        name.setColumns(10);
        name.setBounds(408, 137, 192, 30);
        frame.getContentPane().add(name);

        phone = new JTextField();
        phone.setColumns(10);
        phone.setBounds(408, 484, 192, 30);
        frame.getContentPane().add(phone);

        location1 = new JTextField();
        location1.setColumns(10);
        location1.setBounds(408, 236, 192, 30);
        frame.getContentPane().add(location1);

        eid = new JTextField();
        eid.setColumns(10);
        eid.setBounds(408, 328, 192, 30);
        frame.getContentPane().add(eid);

        spec = new JTextField();
        spec.setColumns(10);
        spec.setBounds(408, 376, 192, 30);
        frame.getContentPane().add(spec);


        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(408, 425, 192, 30);
        frame.getContentPane().add(textField_6);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(625, 425, 192, 30);
        frame.getContentPane().add(textField_7);

        pass = new JTextField();
        pass.setBounds(408, 186, 192, 30);
        frame.getContentPane().add(pass);

        JButton btnRegister = new JButton("REGISTER");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	 Doctor newDoctor = new Doctor();
                 String doctorId = UUID.randomUUID().toString();
                 newDoctor.setId(doctorId);
                 newDoctor.setName(name.getText());
                 newDoctor.setLocation(location1.getText());
                 newDoctor.setGender(comboBox1.getSelectedItem());
                 newDoctor.setPassword(pass.getText());
                 newDoctor.setCategory(spec.getText());
                 newDoctor.setMobileNumber(phone.getText());
                 newDoctor.setEmailId(eid.getText());
                 newDoctor.setTiming(textField_6.getText());
                 newDoctor.setTiming(textField_7.getText());

                 DoctorService doctorService = new DoctorServiceImpl();

                try {

                    //1. Register Doctor First
                   
                    String message = doctorService.register(newDoctor);

                    //2. Add available slots of Doctor
                    AppointmentService appointmentService = new AppointmentServiceImpl();
                    List<Slot> slots = new ArrayList<>();
                    Slot slot1 = new Slot();
                    slot1.setDoctorId(doctorId);
                    slot1.setTimeSlot(textField_6.getText());
                    Slot slot2 = new Slot();
                    slot2.setDoctorId(doctorId);
                    slot2.setTimeSlot(textField_7.getText());
                    slots.add(slot1);
                    slots.add(slot2);
                    appointmentService.addSlotsForDoctor(slots);

                   JOptionPane.showMessageDialog(frame, message);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }


        });
        btnRegister.setBackground(Color.YELLOW);
        btnRegister.setBounds(324, 573, 114, 25);
        frame.getContentPane().add(btnRegister);
    }
}