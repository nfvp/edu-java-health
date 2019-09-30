package pt.dlt.health.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.dlt.health.dto.Doctor;
import pt.dlt.health.dto.Speciality;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
    Optional<Doctor> findById(Long id);
    List<Doctor> findByName(String name);
    List<Doctor> findBySpeciality(Speciality speciality);
    List<Doctor> findByWage(Double wage);

}