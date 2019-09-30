package pt.dlt.health.dal;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pt.dlt.health.dto.Appointment;
import pt.dlt.health.repository.AppointmentRepository;

@Controller
public class AppointmentDAL {

    private @Autowired AppointmentRepository appointmentRepository;

    public List<Appointment> getListAppointment() {
        List<Appointment> appointments = new ArrayList<>();
        appointmentRepository.findAll().forEach(appointments::add);
        return appointments;
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointment;
    }

    public Appointment getAppointment(Long id) {
        return new Appointment();
    }

    public void deleteAppointment(Long id) {
        return;
    }

}
