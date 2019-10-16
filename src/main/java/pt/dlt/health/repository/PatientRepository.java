package pt.dlt.health.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.dlt.health.dto.Doctor;
import pt.dlt.health.dto.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findById(Long id);

    List<Doctor> findByName(String name);

    List<Doctor> findByGender(char gender);

    List<Doctor> findByCitizenCard(int citizenCard);

    List<Doctor> findByFiscalNumber(int fiscalNumber);

    List<Doctor> findByPhoneNumber(int phoneNumber);

    List<Doctor> findByAddress(String address);

    List<Doctor> findByInsuranceNumber(String insuranceNumber);

    List<Doctor> findBySocialSecurityNumber(Long socialSecurityNumber);

}
