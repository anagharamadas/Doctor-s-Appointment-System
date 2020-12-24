package com.login.system.screens;

import com.login.system.beans.Doctor;
import com.login.system.service.ConnectionUtil;
import com.login.system.service.DoctorService;
import com.login.system.service.DoctorServiceImpl;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class DoctorLogin {

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
                    DoctorLogin window = new DoctorLogin();
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
    public DoctorLogin() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        JOptionPane.showMessageDialog(frame,  ConnectionUtil.checkConnectionOnStartUp());
        frame.getContentPane().setBackground(UIManager.getColor("Slider.altTrackColor"));
        frame.setBounds(100, 100, 1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        addLabel(frame);

        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon("/home/user/Desktop/images.png"));
        label_1.setBounds(348, 204, 324, 147);
        frame.getContentPane().add(label_1);

        JLabel lblDoctorName = new JLabel("Name");
        lblDoctorName.setFont(new Font("Dialog", Font.BOLD, 14));
        lblDoctorName.setBounds(308, 300, 130, 15);
        frame.getContentPane().add(lblDoctorName);

        JLabel lblNewLabel = new JLabel("Password");
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNewLabel.setBounds(308, 350, 107, 15);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(514, 300, 216, 25);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(514, 350, 216, 25);
        frame.getContentPane().add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                DoctorService doctorService = new DoctorServiceImpl();
                try {
                    Doctor doctor = doctorService.login(textField.getText(), passwordField.getText());
                    if (null != doctor) {
                        JOptionPane.showMessageDialog(frame, "Welcome Doctor, " + doctor.getName());
                        DoctorsHome.main(new String[]{
                                doctor.getName(), doctor.getId()
                        });
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid Credentials, Please Try to Register");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error occured. " + ex.getMessage() + " Please Contact Administrator", "System Error", 1);
                    ex.printStackTrace();
                }
            }
        });
        btnLogin.setBackground(Color.YELLOW);
        btnLogin.setBounds(348, 400, 114, 32);
        frame.getContentPane().add(btnLogin);

        JButton btnRegister = new JButton("REGISTER");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                DoctorRegistration info = new DoctorRegistration();
                DoctorRegistration.main(null);


            }
        });
        btnRegister.setBackground(Color.ORANGE);
        btnRegister.setFont(new Font("FreeSerif", Font.BOLD, 12));
        btnRegister.setBounds(568, 400, 137, 32);
        frame.getContentPane().add(btnRegister);
    }

    private void addLabel(JFrame frame) {
        JLabel label = new JLabel("DOCTOR APPOINTMENT");
        label.setFont(new Font("FreeMono", Font.BOLD, 26));
        label.setBounds(348, 45, 333, 47);
        frame.getContentPane().add(label);
    }


}