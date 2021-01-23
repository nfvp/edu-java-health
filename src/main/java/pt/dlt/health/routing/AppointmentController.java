package pt.dlt.health.routing;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import pt.dlt.health.dto.Appointment;
import pt.dlt.health.exception.NoAppointmentFoundException;
import pt.dlt.health.services.AppointmentService;

@RestController
@RequestMapping("/api")
@Api(tags = "Appointment", value = "Appointment Controller", description = "Controller for manipulating the entity \"Appointment\"")
@CrossOrigin
public class AppointmentController {
    
    private Logger logger = Logger.getLogger("Routing Layer");
    
    private @Autowired AppointmentService appointmentService;
    
    
    @GetMapping("/appointments")
    public List<Appointment> getListAppointment() {
        logger.info("getListAppointment");
        return appointmentService.getListAppointment();
    }
    
    @PostMapping("/appointments")
    Appointment createAppointment(@RequestBody Appointment appointment) {
        logger.info("createAppointment");
        return appointmentService.createAppointment(appointment);
    }
    
    @GetMapping("/appointments/{id}")
    Appointment getAppointment(@PathVariable Long id) throws NoAppointmentFoundException {
        logger.info("getAppointment");
        return appointmentService.getAppointment(id);
    }
    
    @PutMapping("/appointments/{id}")
    Appointment updateAppointment(@RequestBody Appointment appointment) throws NoAppointmentFoundException {
        logger.info("updateAppointment");
        return appointmentService.updateAppointment(appointment);
    }
    
    @DeleteMapping("/appointments/{id}")
    void deleteAppointment(@PathVariable Long id) throws NoAppointmentFoundException {
        logger.info("deleteAppointment");
        appointmentService.deleteAppointment(id);
    }
    
}
