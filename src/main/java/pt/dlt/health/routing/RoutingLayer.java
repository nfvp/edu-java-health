package pt.dlt.health.routing;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.dlt.health.bl.BusinessLayer;
import pt.dlt.health.dto.Appointment;
import pt.dlt.health.dto.Doctor;
import pt.dlt.health.dto.Patient;

@RestController
public class RoutingLayer {

    Logger LOGGER = Logger.getLogger("RoutingLayer");

    private @Autowired BusinessLayer businessLayer;
    
    @GetMapping("/doctors")
    public List<Doctor> getListDoctor() {
        LOGGER.info("BusinessLayer.getListDoctor()");
        return businessLayer.getListDoctor();
    }

    @GetMapping("/patients")
    public List<Patient> getListPatient() {
        LOGGER.info("BusinessLayer.getListPatient()");
        return businessLayer.getListPatient();
    }

    @GetMapping("/appointments")
    public List<Appointment> getListAppointment() {
        LOGGER.info("BusinessLayer.getListAppointment()");
        return businessLayer.getListAppointment();
    }

}
