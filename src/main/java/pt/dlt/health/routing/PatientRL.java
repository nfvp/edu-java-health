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
import pt.dlt.health.bl.PatientBL;
import pt.dlt.health.dto.Patient;
import pt.dlt.health.exception.NoPatientFoundException;

@RestController
@RequestMapping("/api")
public class PatientRL {

    private Logger LOGGER = Logger.getLogger("Routing Layer");

    private @Autowired PatientBL patientBL;

    
    @GetMapping("/patients")
    public List<Patient> getListPatient() {
        LOGGER.info("getListPatient");
        return patientBL.getListPatient();
    }

    @PostMapping("/patients")
    Patient createPatient(@RequestBody Patient patient) {
        LOGGER.info("createPatient");
        return patientBL.createPatient(patient);
    }

    @GetMapping("/patients/{id}")
    Patient getPatient(@PathVariable Long id) throws NoPatientFoundException {
        LOGGER.info("getPatient");
        return patientBL.getPatient(id);
    }

    @PutMapping("/patients")
    Patient updatePatient(@RequestBody Patient patient) throws NoPatientFoundException {
        LOGGER.info("updatePatient");
        return patientBL.updatePatient(patient);
    }

    @DeleteMapping("/patients/{id}")
    void deletePatient(@PathVariable Long id) throws NoPatientFoundException {
        LOGGER.info("deletePatient");
        patientBL.deletePatient(id);
    }

}