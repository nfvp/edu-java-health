package pt.dlt.health.routing;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pt.dlt.health.bl.DoctorBL;
import pt.dlt.health.dto.Doctor;
import pt.dlt.health.exception.NoDoctorFoundException;

@RestController
public class DoctorRL {

    private @Autowired DoctorBL doctorBL;

    @GetMapping("/doctors")
    public List<Doctor> getListDoctor() {
        return doctorBL.getListDoctor();
    }

    @PostMapping("/doctors")
    Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorBL.createDoctor(doctor);
    }

    @GetMapping("/doctors/{id}")
    Doctor getDoctor(@PathVariable Long id) throws NoDoctorFoundException {
        return doctorBL.getDoctor(id);
    }

    @DeleteMapping("/doctors/{id}")
    void deleteDoctor(@PathVariable Long id) {
        doctorBL.deleteDoctor(id);
    }

}
