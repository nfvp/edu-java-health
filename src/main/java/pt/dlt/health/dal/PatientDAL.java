package pt.dlt.health.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pt.dlt.health.aspect.CustomLogger;
import pt.dlt.health.dto.Patient;
import pt.dlt.health.exception.NoPatientFoundException;
import pt.dlt.health.repository.PatientRepository;

@Controller
public class PatientDAL {

    private @Autowired PatientRepository patientRepository;

    @CustomLogger
    public List<Patient> getListPatient() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add);
        return patients;
    }

    @CustomLogger
    public Patient createPatient(Patient patient) {
        return patient;
    }

    @CustomLogger
    public Patient getPatient(Long id) throws NoPatientFoundException {
        Optional<Patient> response = patientRepository.findById(id);
        if (response.isEmpty()) {
            throw new NoPatientFoundException();
        }
        return response.get();
    }

    @CustomLogger
    public void deletePatient(Long id) {
        return;
    }

}
