package pt.dlt.health.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.dlt.health.dto.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    
    Optional<Appointment> findById(Long id);

}