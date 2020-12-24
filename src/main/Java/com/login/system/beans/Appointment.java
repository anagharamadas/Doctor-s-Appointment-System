package com.login.system.beans;

public class Appointment {

    private String id;
    private String doctorId;
    private String patientId;
    private String slotId;
    private String appointmentWithDoctor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getAppointmentWithDoctor() {
        return appointmentWithDoctor;
    }

    public void setAppointmentWithDoctor(String appointmentWithDoctor) {
        this.appointmentWithDoctor = appointmentWithDoctor;
    }
}
