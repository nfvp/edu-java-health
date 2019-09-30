package pt.dlt.health.dal;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pt.dlt.health.dto.Patient;
import pt.dlt.health.repository.PatientRepository;

@Controller
public class PatientDAL {

    private @Autowired PatientRepository patientRepository;

    public List<Patient> getListPatient() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add);
        return patients;
    }

    public Patient createPatient(Patient patient) {
        return patient;
    }

    public Patient getPatient(Long id) {
        return new Patient();
    }

    public void deletePatient(Long id) {
        return;
    }

}
