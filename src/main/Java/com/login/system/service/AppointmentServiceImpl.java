package com.login.system.service;

import com.login.system.beans.*;
import com.login.system.constants.Queries;
import com.login.system.database.DataBaseService;
import com.login.system.database.MySqlDatabaseServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AppointmentServiceImpl implements AppointmentService {

    @Override
    public List<Doctor> listOfAllDoctors() {

        List<Doctor> doctors = new ArrayList<>();
        DataBaseService dataBaseService = new MySqlDatabaseServiceImpl();
        Connection connection = dataBaseService.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(Queries.GET_ALL_DOCTORS_QUERY);
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getString("id"));
                doctor.setName(rs.getString("name"));
                doctor.setMobileNumber(rs.getString("mobileNumber"));
                doctor.setCategory(rs.getString("category"));
                doctors.add(doctor);
            }
        } catch (Exception e) {
            System.out.println("Failed getting slots");
        }
        return doctors;
    }


    @Override
    public List<AppointmentView> getAllAppoitntmentForPatient(String patientId) {
        List<AppointmentView> appointments = new ArrayList<>();
        DataBaseService dataBaseService = new MySqlDatabaseServiceImpl();
        Connection connection = dataBaseService.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(Queries.GET_ALL_APPOINTMENTS_FOR_PATIENT);
            stmt.setString(1, patientId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                AppointmentView appointment = new AppointmentView();
                PreparedStatement stmt1 = connection.prepareStatement(Queries.GET_DOCTOR_QUERY);
                stmt1.setString(1, rs.getString("doctroId"));
                ResultSet rs1 = stmt1.executeQuery();

                while (rs1.next()) {
                    appointment.setDoctorName(rs1.getString("name"));
                }

                PreparedStatement stmt2 = connection.prepareStatement(Queries.GET_SLOT_QUERY);
                stmt2.setString(1, rs.getString("slotId"));
                ResultSet rs2 = stmt2.executeQuery();

                while (rs2.next()) {
                    appointment.setTimeSlot(rs2.getString("timeSlot"));
                    if (rs2.getBoolean("booked")) {
                        appointment.setStatus("Confirmed");
                    } else {
                        appointment.setStatus("Not Confirmed or Cancelled");
                    }
                }

                appointments.add(appointment);
            }
        } catch (Exception e) {
            System.out.println("Failed getting appointments");
            e.printStackTrace();
        }
        return appointments;
    }

    @Override
    public List<BookedAppointmentView> getAllAppoitntmentForDoctor(String doctorId) {
        List<BookedAppointmentView> appointments = new ArrayList<>();
        DataBaseService dataBaseService = new MySqlDatabaseServiceImpl();
        Connection connection = dataBaseService.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(Queries.GET_ALL_APPOINTMENTS_FOR_DOCTOR);
            stmt.setString(1, doctorId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BookedAppointmentView appointment = new BookedAppointmentView();
                PreparedStatement stmt1 = connection.prepareStatement(Queries.GET_PATIENT_QUERY);
                stmt1.setString(1, rs.getString("patientId"));
                ResultSet rs1 = stmt1.executeQuery();

                while (rs1.next()) {
                    appointment.setPatientDetail(rs1.getString("name") +"  "+ rs1.getString("address") + "  " + rs1.getString("mobileNumber"));
                }

                PreparedStatement stmt2 = connection.prepareStatement(Queries.GET_SLOT_QUERY);
                stmt2.setString(1, rs.getString("slotId"));
                ResultSet rs2 = stmt2.executeQuery();

                while (rs2.next()) {
                    appointment.setTimeSlot(rs2.getString("timeSlot"));
                    if (rs2.getBoolean("booked")) {
                        appointment.setStatus("Confirmed");
                    } else {
                        appointment.setStatus("Not Confirmed or Cancelled");
                    }
                }

                appointments.add(appointment);
            }
        } catch (Exception e) {
            System.out.println("Failed getting appointments for Doctor");
            e.printStackTrace();
        }
        return appointments;
    }

    @Override
    public List<Slot> getAllSlotsForDoctor(String doctorId) {
        List<Slot> slots = new ArrayList<>();
        DataBaseService dataBaseService = new MySqlDatabaseServiceImpl();
        Connection connection = dataBaseService.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(Queries.GET_ALL_SLOTS_FOR_DOCTOR);
            stmt.setString(1, doctorId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Slot slot = new Slot();
                slot.setId(rs.getString("id"));
                slot.setDoctorId(rs.getString("doctorId"));
                slot.setTimeSlot(rs.getString("timeSlot"));
                if (rs.getBoolean("booked")) {
                    slot.setBooked(true);
                } else {
                    slot.setBooked(false);
                }
                slots.add(slot);
            }
        } catch (Exception e) {
            System.out.println("Failed getting appointments");
        }
        return slots;
    }

    @Override
    public String addSlotsForDoctor(List<Slot> slots) throws Exception {
        DataBaseService dataBaseService = new MySqlDatabaseServiceImpl();
        Connection connection = dataBaseService.getConnection();

        if (null != slots) {

            slots.forEach(slot -> {
                try {
                    PreparedStatement stmt = connection.prepareStatement(Queries.ADD_SLOTS_QUERY);

                    stmt.setString(1, UUID.randomUUID().toString());
                    stmt.setString(2, slot.getDoctorId());
                    stmt.setString(3, slot.getTimeSlot());
                    stmt.setBoolean(4, false);
                    int i = stmt.executeUpdate();
                    System.out.println(i + " Slots Created");
                } catch (Exception e) {

                }
            });
        }
        return "OK";
    }

    @Override
    public String createAppointment(Appointment appointment) {
        DataBaseService dataBaseService = new MySqlDatabaseServiceImpl();
        Connection connection = dataBaseService.getConnection();
        if (null != appointment) {
            try {
                PreparedStatement stmt = connection.prepareStatement(Queries.ADD_APPOINTMENT_QUERY);

                stmt.setString(1, appointment.getId());
                stmt.setString(2, appointment.getPatientId());
                stmt.setString(3, appointment.getSlotId());
                stmt.setString(4, appointment.getDoctorId());
                int i = stmt.executeUpdate();
                System.out.println(i + " Appointment Created");

                PreparedStatement stmt1 = connection.prepareStatement(Queries.BOOK_SLOT);

                stmt1.setInt(1, 1);
                stmt1.setString(2, appointment.getSlotId());
                int i1 = stmt1.executeUpdate();
                System.out.println(i1 + " Slot Marked as Booked");
                return "Appointment Created Successfully. Go to My Appointments";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "OK";
    }
}
