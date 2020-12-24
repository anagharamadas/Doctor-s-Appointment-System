package com.login.system.beans;

public class BookedAppointmentView {

    private String patientDetail;
    private String timeSlot;
    private String status;

    public String getPatientDetail() {
        return patientDetail;
    }

    public void setPatientDetail(String patientDetail) {
        this.patientDetail = patientDetail;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
