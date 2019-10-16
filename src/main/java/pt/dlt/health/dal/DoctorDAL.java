package pt.dlt.health.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pt.dlt.health.aspect.CustomLogger;
import pt.dlt.health.dto.Doctor;
import pt.dlt.health.exception.NoDoctorFoundException;
import pt.dlt.health.repository.DoctorRepository;

@Controller
public class DoctorDAL {

    private @Autowired DoctorRepository doctorRepository;

    @CustomLogger
    public List<Doctor> getListDoctor() {
        List<Doctor> doctors = new ArrayList<>();
        doctorRepository.findAll().forEach(doctors::add);
        return doctors;
    }

    @CustomLogger
    public Doctor createDoctor(Doctor doctor) {
        Doctor newDoctor = doctorRepository.save(doctor);
        return newDoctor;
    }

    @CustomLogger
    public Doctor getDoctor(Long id) throws NoDoctorFoundException {
        Optional<Doctor> response = doctorRepository.findById(id);
        if (response.isEmpty()) {
            throw new NoDoctorFoundException();
        }
        return response.get();
    }

    @CustomLogger
    public Doctor updateDoctor(Doctor doctor) throws NoDoctorFoundException {
        Optional<Doctor> response = doctorRepository.findById(doctor.getId());
        if (response.isEmpty()) {
            throw new NoDoctorFoundException();
        }
        Doctor dbDoctor = response.get();
        dbDoctor.setName(doctor.getName());
        dbDoctor.setPhoneNumber(doctor.getPhoneNumber());
        dbDoctor.setGender(doctor.getGender());
        dbDoctor.setAddress(doctor.getAddress());
        dbDoctor.setWage(doctor.getWage());
        dbDoctor.setSpeciality(doctor.getSpeciality());
        doctorRepository.save(dbDoctor);
        return dbDoctor;
    }

    @CustomLogger
    public void deleteDoctor(Long id) throws NoDoctorFoundException {
        Optional<Doctor> response = doctorRepository.findById(id);
        if (response.isEmpty()) {
            throw new NoDoctorFoundException();
        }
        doctorRepository.delete(response.get());
    }

}
