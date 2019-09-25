package pt.dlt.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.dlt.health.dto.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    

}