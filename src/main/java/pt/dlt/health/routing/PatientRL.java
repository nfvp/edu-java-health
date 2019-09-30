package pt.dlt.health.routing;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pt.dlt.health.bl.PatientBL;
import pt.dlt.health.dto.Patient;

@RestController
public class PatientRL {

    private @Autowired PatientBL patientBL;
    
    @GetMapping("/patients")
    public List<Patient> getListPatient() {
        return patientBL.getListPatient();
    }

    @PostMapping("/patients")
    Patient createPatient(@RequestBody Patient patient) {
        return patientBL.createPatient(patient);
    }

    @GetMapping("/patients/{id}")
    Patient getPatient(@PathVariable Long id) {
        return patientBL.getPatient(id);
    }

    @DeleteMapping("/patients/{id}")
    void deletePatient(@PathVariable Long id) {
        patientBL.deletePatient(id);
    }

}