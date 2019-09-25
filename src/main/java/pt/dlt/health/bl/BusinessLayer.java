package pt.dlt.health.bl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pt.dlt.health.dal.DataAccessLayer;
import pt.dlt.health.dto.Appointment;
import pt.dlt.health.dto.Doctor;
import pt.dlt.health.dto.Patient;

@Controller
public class BusinessLayer {

    private @Autowired DataAccessLayer dataAccessLayer;

    public List<Doctor> getListDoctor() {
        return dataAccessLayer.getListDoctor();
    }

    public List<Patient> getListPatient() {
        return dataAccessLayer.getListPatient();
    }

    public List<Appointment> getListAppointment() {
        return dataAccessLayer.getListAppointment();
    }

}
