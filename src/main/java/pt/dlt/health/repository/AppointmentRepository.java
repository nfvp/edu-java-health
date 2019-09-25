package pt.dlt.health.repository;

import org.springframework.data.repository.CrudRepository;
import pt.dlt.health.dto.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    

}