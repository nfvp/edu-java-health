package pt.dlt.health.routing;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import pt.dlt.health.dto.Doctor;
import pt.dlt.health.exception.NoDoctorFoundException;
import pt.dlt.health.services.DoctorService;

@RestController
@RequestMapping("/api")
@Api(tags = "Doctor", value = "Doctor Controller", description = "Controller for manipulating the entity \"Doctor\"")
@CrossOrigin
public class DoctorController {
    
    private Logger logger = Logger.getLogger("Routing Layer");
    
    private @Autowired DoctorService doctorService;
    
    
    @GetMapping("/doctors")
    public List<Doctor> getListDoctor() {
        logger.info("getListDoctor");
        return doctorService.getListDoctor();
    }
    
    @PostMapping("/doctors")
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        logger.info("createDoctor");
        return doctorService.createDoctor(doctor);
    }
    
    @GetMapping("/doctors/{id}")
    public Doctor getDoctor(@PathVariable Long id) throws NoDoctorFoundException {
        logger.info("getDoctor");
        return doctorService.getDoctor(id);
    }
    
    @PutMapping("/doctors")
    public Doctor updateDoctor(@RequestBody Doctor doctor) throws NoDoctorFoundException {
        logger.info("updateDoctor");
        return doctorService.updateDoctor(doctor);
    }
    
    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor(@PathVariable Long id) throws NoDoctorFoundException {
        logger.info("deleteDoctor");
        doctorService.deleteDoctor(id);
    }
    
}
