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
import pt.dlt.health.dto.Patient;
import pt.dlt.health.exception.NoPatientFoundException;
import pt.dlt.health.services.PatientService;

@RestController
@RequestMapping("/api")
@Api(tags = "Patient", value = "Patient Controller", description = "Controller for manipulating the entity \"Patient\"")
@CrossOrigin
public class PatientController {
    
    private Logger logger = Logger.getLogger("Routing Layer");
    
    private @Autowired PatientService patientService;
    
    
    @GetMapping("/patients")
    public List<Patient> getListPatient() {
        logger.info("getListPatient");
        return patientService.getListPatient();
    }
    
    @PostMapping("/patients")
    public Patient createPatient(@RequestBody Patient patient) {
        logger.info("createPatient");
        return patientService.createPatient(patient);
    }
    
    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable Long id) throws NoPatientFoundException {
        logger.info("getPatient");
        return patientService.getPatient(id);
    }
    
    @PutMapping("/patients")
    public Patient updatePatient(@RequestBody Patient patient) throws NoPatientFoundException {
        logger.info("updatePatient");
        return patientService.updatePatient(patient);
    }
    
    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable Long id) throws NoPatientFoundException {
        logger.info("deletePatient");
        patientService.deletePatient(id);
    }
    
}
