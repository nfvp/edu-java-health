package pt.dlt.health.routing;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.dlt.health.bl.AppointmentBL;
import pt.dlt.health.dto.Appointment;
import pt.dlt.health.exception.NoAppointmentFoundException;

@RestController
@RequestMapping("/api")
public class AppointmentRL {

    private Logger LOGGER = Logger.getLogger("Routing Layer");

    private @Autowired AppointmentBL appointmentBL;

    @GetMapping("/appointments")
    public List<Appointment> getListAppointment() {
        LOGGER.info("getListAppointment");
        return appointmentBL.getListAppointment();
    }

    @PostMapping("/appointments")
    Appointment createAppointment(@RequestBody Appointment appointment) {
        LOGGER.info("createAppointment");
        return appointmentBL.createAppointment(appointment);
    }

    @GetMapping("/appointments/{id}")
    Appointment getAppointment(@PathVariable Long id) throws NoAppointmentFoundException {
        LOGGER.info("getAppointment");
        return appointmentBL.getAppointment(id);
    }

    @PutMapping("/appointments/{id}")
    Appointment updateAppointment(@RequestBody Appointment appointment) throws NoAppointmentFoundException {
        LOGGER.info("updateAppointment");
        return appointmentBL.updateAppointment(appointment);
    }

    @DeleteMapping("/appointments/{id}")
    void deleteAppointment(@PathVariable Long id) throws NoAppointmentFoundException {
        LOGGER.info("deleteAppointment");
        appointmentBL.deleteAppointment(id);
    }

}