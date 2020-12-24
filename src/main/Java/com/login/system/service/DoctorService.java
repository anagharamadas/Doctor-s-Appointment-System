package com.login.system.service;

import com.login.system.beans.Doctor;

public interface DoctorService {

    public Doctor login(String userName, String password) throws Exception;

    public String register(Doctor doctor) throws Exception;

}
