package com.login.system.service;

import com.login.system.beans.Doctor;
import com.login.system.beans.Patient;

public interface PatientService {

    public Patient login(String userName, String password) throws Exception;

    public String register(Patient patient) throws Exception;
}
