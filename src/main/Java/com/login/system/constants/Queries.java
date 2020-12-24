package com.login.system.constants;

public class Queries {

    public static final String GET_ALL_DOCTORS_QUERY = "select * from doctors";
    public static final String GET_DOCTOR_QUERY = "select * from doctors where id=?";
    public static final String GET_PATIENT_QUERY = "select * from patients where id=?";
    public static final String GET_SLOT_QUERY = "select * from slots where id=?";
    public static final String GET_ALL_PATIENTS_QUERY = "select * from patients";
    public static final String DOCTOR_REGISTRATION_QUERY = "insert into doctors values(?,?,?,?,?,?,?,?,?)";
    public static final String PATIENT_REGISTRATION_QUERY = "insert into patients values(?,?,?,?,?,?,?,?)";
    public static final String ADD_SLOTS_QUERY = "insert into slots values(?,?,?,?)";
    public static final String ADD_APPOINTMENT_QUERY = "insert into appointments values(?,?,?,?)"; // id , patient id, slot id (slot have doctorId)
    public static final String GET_ALL_APPOINTMENTS_FOR_PATIENT = "select * from appointments where patientId=?";
    public static final String GET_ALL_APPOINTMENTS_FOR_DOCTOR = "select * from appointments where doctroId=?";
    public static final String GET_ALL_SLOTS_FOR_DOCTOR = "select * from slots where doctorId=?";
    public static final String BOOK_SLOT = "UPDATE slots SET booked = ? WHERE id = ?";
}
