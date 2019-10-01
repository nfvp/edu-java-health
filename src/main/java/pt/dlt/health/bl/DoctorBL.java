package pt.dlt.health.bl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pt.dlt.health.dal.DoctorDAL;
import pt.dlt.health.dto.Doctor;
import pt.dlt.health.exception.NoDoctorFoundException;

@Controller
public class DoctorBL {

	private @Autowired DoctorDAL doctorDAL;

	public List<Doctor> getListDoctor() {
		return doctorDAL.getListDoctor();
	}

	public Doctor createDoctor(Doctor d) {
		return doctorDAL.createDoctor(d);
	}

	public Doctor getDoctor(Long id) throws NoDoctorFoundException {
		return doctorDAL.getDoctor(id);
	}

	public void deleteDoctor(Long id) {
        doctorDAL.deleteDoctor(id);
	}

}
