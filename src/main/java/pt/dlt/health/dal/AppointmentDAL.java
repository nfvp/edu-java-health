package pt.dlt.health.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pt.dlt.health.aspect.CustomLogger;
import pt.dlt.health.dto.Appointment;
import pt.dlt.health.exception.NoAppointmentFoundException;
import pt.dlt.health.repository.AppointmentRepository;

@Controller
public class AppointmentDAL {

    private @Autowired AppointmentRepository appointmentRepository;

    @CustomLogger
    public List<Appointment> getListAppointment() {
        List<Appointment> appointments = new ArrayList<>();
        appointmentRepository.findAll().forEach(appointments::add);
        return appointments;
    }

    @CustomLogger
    public Appointment createAppointment(Appointment appointment) {
        Appointment newAppointment = appointmentRepository.save(appointment);
        return newAppointment;
    }

    @CustomLogger
    public Appointment getAppointment(Long id) throws NoAppointmentFoundException {
        Optional<Appointment> response = appointmentRepository.findById(id);
        if (response.isEmpty()) {
            throw new NoAppointmentFoundException();
        }
        return response.get();
    }

    @CustomLogger
    public Appointment updateAppointment(Appointment appointment) throws NoAppointmentFoundException {
        Optional<Appointment> response = appointmentRepository.findById(appointment.getId());
        if (response.isEmpty()) {
            throw new NoAppointmentFoundException();
        }
        Appointment dbAppointment = response.get();
        dbAppointment.setDoctor(appointment.getDoctor());
        dbAppointment.setPatient(appointment.getPatient());
        dbAppointment.setStartDate(appointment.getStartDate());
        dbAppointment.setEndDate(appointment.getEndDate());
        appointmentRepository.save(dbAppointment);
        return dbAppointment;
    }

    @CustomLogger
    public void deleteAppointment(Long id) throws NoAppointmentFoundException {
        Optional<Appointment> response = appointmentRepository.findById(id);
        if (response.isEmpty()) {
            throw new NoAppointmentFoundException();
        }
        appointmentRepository.delete(response.get());
    }

}
