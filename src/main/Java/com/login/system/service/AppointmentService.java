package com.login.system.service;

import com.login.system.beans.*;

import java.util.List;

public interface AppointmentService {

    public List<Doctor> listOfAllDoctors();

    public String addSlotsForDoctor(List<Slot> slots) throws Exception;

    public List<Slot> getAllSlotsForDoctor(String doctorId) throws Exception;

    public String createAppointment(Appointment appointment);

    public List<AppointmentView> getAllAppoitntmentForPatient(String patientId);

    public List<BookedAppointmentView> getAllAppoitntmentForDoctor(String doctorId);
}
