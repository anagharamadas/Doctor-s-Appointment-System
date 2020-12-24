package com.login.system.service;

import com.login.system.beans.Doctor;
import com.login.system.database.DataBaseService;
import com.login.system.database.MySqlDatabaseServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.login.system.constants.Queries;

public class DoctorServiceImpl implements DoctorService {

    @Override
    public Doctor login(String userName, String password) throws Exception {
        DataBaseService dataBaseService = new MySqlDatabaseServiceImpl();
        Connection connection = dataBaseService.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(Queries.GET_ALL_DOCTORS_QUERY);
        boolean found = false;
        while (rs.next()) {
            if (found == false) {
                if (rs.getString("name").equalsIgnoreCase(userName)
                        && rs.getString("password").equalsIgnoreCase(password)) {
                    found = true;
                    Doctor doctor = new Doctor();
                    doctor.setId(rs.getString("id"));
                    doctor.setName(rs.getString("name"));
                    return doctor;
                } else {
                    continue;
                }
            }
        }
        if (!found) {
            return null;
        }
        return null;
    }

    @Override
    public String register(Doctor doctor) throws Exception {
        DataBaseService dataBaseService = new MySqlDatabaseServiceImpl();
        Connection connection = dataBaseService.getConnection();
        PreparedStatement stmt = connection.prepareStatement(Queries.DOCTOR_REGISTRATION_QUERY);

        stmt.setString(1, doctor.getId());
        stmt.setString(2, doctor.getName());
        stmt.setString(3, doctor.getLocation());//location
        stmt.setString(4, doctor.getGender());//gender
        stmt.setString(5, doctor.getEmailId());//emailId
        stmt.setString(6, doctor.getCategory());//category
        stmt.setString(7, doctor.getTiming());//timing
        stmt.setString(8, doctor.getMobileNumber());//mobileNumber
        stmt.setString(9, doctor.getPassword());//password

        int i = stmt.executeUpdate();
        System.out.println(i + " Doctor Created");
        return "Doctor " + doctor.getName() + " registered Successfully. Please try to Login";
    }


}
