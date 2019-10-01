package pt.dlt.health.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pt.dlt.health.dto.Doctor;
import pt.dlt.health.exception.NoDoctorFoundException;
import pt.dlt.health.repository.DoctorRepository;

@Controller
public class DoctorDAL {

    private @Autowired DoctorRepository doctorRepository;

    public List<Doctor> getListDoctor() {
        List<Doctor> doctors = new ArrayList<>();
        doctorRepository.findAll().forEach(doctors::add);
        return doctors;
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctor;
    }

    public Doctor getDoctor(Long id) throws NoDoctorFoundException {
        Optional<Doctor> response = doctorRepository.findById(id);
        if (response.isEmpty()) {
            throw new NoDoctorFoundException();
        }
        return response.get();
    }

    public void deleteDoctor(Long id) {
        return;
    }

}
