package com.login.system.screens;

import com.login.system.beans.Appointment;
import com.login.system.beans.ComboItem;
import com.login.system.beans.Doctor;
import com.login.system.beans.Slot;
import com.login.system.service.AppointmentService;
import com.login.system.service.AppointmentServiceImpl;
import com.login.system.service.DoctorService;
import com.login.system.service.DoctorServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BookAppointment {

    private JFrame frame;
    private JComboBox doctors;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookAppointment window = new BookAppointment(args[0]);
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
    public BookAppointment(String patientId) {
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

        JLabel slotLabel = new JLabel("Select a Doctor to make an Appointment");
        slotLabel.setFont(new Font("FreeMono", Font.BOLD, 15));
        slotLabel.setBounds(250, 25, 400, 25);
        frame.getContentPane().add(slotLabel);

        AppointmentService appointmentService = new AppointmentServiceImpl();
        List<Doctor> doctorsList = appointmentService.listOfAllDoctors();

        if (doctorsList != null) {
            int y = 50;
            int count = 0;
            for (Doctor doctor: doctorsList) {
                y = y + 20;

                JLabel doctrosLabel = new JLabel((count +=1) +" Dr."+doctor.getName());
                doctrosLabel.setBounds(300, y, 350, 24);
                doctrosLabel.setFont(new Font("FreeMono", Font.BOLD, 14));
                frame.getContentPane().add(doctrosLabel);


                JLabel categoryLabel = new JLabel(doctor.getCategory());
                categoryLabel.setBounds(450, y, 350, 24);
                categoryLabel.setFont(new Font("FreeMono", Font.BOLD, 13));
                categoryLabel.setForeground(Color.darkGray);
                frame.getContentPane().add(categoryLabel);

                JLabel mobileLabel = new JLabel("Ph: "+ doctor.getMobileNumber());
                mobileLabel.setBounds(630, y, 350, 24);
                mobileLabel.setFont(new Font("FreeMono", Font.BOLD, 13));
                mobileLabel.setForeground(Color.gray);
                frame.getContentPane().add(mobileLabel);
            }
        }

        JLabel mobileLabel = new JLabel("Choose ");
        mobileLabel.setBounds(250, 288, 192, 24);
        mobileLabel.setFont(new Font("FreeMono", Font.BOLD, 13));

        frame.getContentPane().add(mobileLabel);

        doctors = new JComboBox();
        doctors.setBounds(350, 288, 192, 24);
        if (doctorsList != null) {
            doctorsList.forEach(doctor ->  {
                doctors.addItem(new ComboItem(doctor.getName(), doctor.getId()));
            }
        );
        }
        doctors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ComboItem item = (ComboItem) doctors.getSelectedItem();
                ShowSlots.main(new String[]{item.getValue(), patientId});
            }
        });
        frame.getContentPane().add(doctors);


    }



}