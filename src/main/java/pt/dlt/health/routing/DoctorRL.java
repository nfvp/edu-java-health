package pt.dlt.health.routing;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.dlt.health.bl.DoctorBL;
import pt.dlt.health.dto.Doctor;
import pt.dlt.health.exception.NoDoctorFoundException;

@RestController
@RequestMapping("/api")
public class DoctorRL {

    private Logger LOGGER = Logger.getLogger("Routing Layer");

    private @Autowired DoctorBL doctorBL;

    
    @GetMapping("/doctors")
    public List<Doctor> getListDoctor() {
        LOGGER.info("getListDoctor");
        return doctorBL.getListDoctor();
    }

    @PostMapping("/doctors")
    Doctor createDoctor(@RequestBody Doctor doctor) {
        LOGGER.info("createDoctor");
        return doctorBL.createDoctor(doctor);
    }

    @GetMapping("/doctors/{id}")
    Doctor getDoctor(@PathVariable Long id) throws NoDoctorFoundException {
        LOGGER.info("getDoctor");
        return doctorBL.getDoctor(id);
    }

    @PutMapping("/doctors")
    Doctor updateDoctor(@RequestBody Doctor doctor) throws NoDoctorFoundException {
        LOGGER.info("updateDoctor");
        return doctorBL.updateDoctor(doctor);
    }

    @DeleteMapping("/doctors/{id}")
    void deleteDoctor(@PathVariable Long id) throws NoDoctorFoundException {
        LOGGER.info("deleteDoctor");
        doctorBL.deleteDoctor(id);
    }

}
