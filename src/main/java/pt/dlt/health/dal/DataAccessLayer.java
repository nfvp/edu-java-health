package pt.dlt.health.dal;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pt.dlt.health.aspect.CustomLogger;
import pt.dlt.health.dto.Appointment;
import pt.dlt.health.dto.Doctor;
import pt.dlt.health.dto.Patient;
import pt.dlt.health.repository.AppointmentRepository;
import pt.dlt.health.repository.DoctorRepository;
import pt.dlt.health.repository.PatientRepository;

@Controller
public class DataAccessLayer {

    private @Autowired DoctorRepository doctorRepository;
    private @Autowired PatientRepository patientRepository;
    private @Autowired AppointmentRepository appointmentRepository;

    @CustomLogger
    public List<Doctor> getListDoctor() {
        List<Doctor> doctors = new ArrayList<>();
        doctorRepository.findAll().forEach(doctors::add);
        return doctors;
    }

    @CustomLogger
    public List<Patient> getListPatient() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add);
        return patients;
    }

    @CustomLogger
    public List<Appointment> getListAppointment() {
        List<Appointment> appointments = new ArrayList<>();
        appointmentRepository.findAll().forEach(appointments::add);
        return appointments;
    }

}
