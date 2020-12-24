package com.login.system.service;

import com.login.system.beans.Patient;
import com.login.system.constants.Queries;
import com.login.system.database.DataBaseService;
import com.login.system.database.MySqlDatabaseServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatientServiceImpl implements PatientService {
    @Override
    public Patient login(String userName, String password) throws Exception {
        DataBaseService dataBaseService = new MySqlDatabaseServiceImpl();
        Connection connection = dataBaseService.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(Queries.GET_ALL_PATIENTS_QUERY);
        boolean found = false;
        while (rs.next()) {
            if (found == false) {
                if (null != rs.getString("name") && rs.getString("name").equalsIgnoreCase(userName)
                        && null != rs.getString("password") && rs.getString("password").equalsIgnoreCase(password)) {
                    found = true;
                    Patient patient = new Patient();
                    patient.setId(rs.getString("id"));
                    patient.setName(rs.getString("name"));
                    return patient;
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
    public String register(Patient patient) throws Exception {
        DataBaseService dataBaseService = new MySqlDatabaseServiceImpl();
        Connection connection = dataBaseService.getConnection();
        PreparedStatement stmt = connection.prepareStatement(Queries.PATIENT_REGISTRATION_QUERY);

        stmt.setString(1, patient.getId());
        stmt.setString(2, patient.getName());
        stmt.setString(3, patient.getPassword());//location
        stmt.setString(4, patient.getEmail());//emailId
        stmt.setString(5, patient.getDob());//category
        stmt.setString(6, patient.getGender());//timing
        stmt.setString(7, patient.getMobileNumber());//mobileNumber
        stmt.setString(8, patient.getAddress());//mobileNumber

        int i = stmt.executeUpdate();
        System.out.println(i + " Patient Created");
        return "Patient " + patient.getName() + " registered Successfully. Please try to Login";
    }
}
