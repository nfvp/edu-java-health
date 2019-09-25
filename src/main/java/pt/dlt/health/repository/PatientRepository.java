package pt.dlt.health.repository;

import org.springframework.data.repository.CrudRepository;
import pt.dlt.health.dto.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    

}