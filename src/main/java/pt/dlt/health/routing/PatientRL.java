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
import pt.dlt.health.bl.PatientBL;
import pt.dlt.health.dto.Patient;
import pt.dlt.health.exception.NoPatientFoundException;

@RestController
@RequestMapping("/api")
@Api(tags = "Patients", value = "Patient Routing Layer")
@CrossOrigin
public class PatientRL {

    private Logger log = Logger.getLogger("Routing Layer");

    private @Autowired PatientBL patientBL;

    
    @GetMapping("/patients")
    public List<Patient> getListPatient() {
        log.info("getListPatient");
        return patientBL.getListPatient();
    }

    @PostMapping("/patients")
    public Patient createPatient(@RequestBody Patient patient) {
        log.info("createPatient");
        return patientBL.createPatient(patient);
    }

    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable Long id) throws NoPatientFoundException {
        log.info("getPatient");
        return patientBL.getPatient(id);
    }

    @PutMapping("/patients")
    public Patient updatePatient(@RequestBody Patient patient) throws NoPatientFoundException {
        log.info("updatePatient");
        return patientBL.updatePatient(patient);
    }

    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable Long id) throws NoPatientFoundException {
        log.info("deletePatient");
        patientBL.deletePatient(id);
    }

}