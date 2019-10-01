package pt.dlt.health.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pt.dlt.health.dto.Patient;
import pt.dlt.health.exception.NoPatientFoundException;
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

    public Patient getPatient(Long id) throws NoPatientFoundException {
        Optional<Patient> response = patientRepository.findById(id);
        if (response.isEmpty()) {
            throw new NoPatientFoundException();
        }
        return response.get();
    }

    public void deletePatient(Long id) {
        return;
    }

}
