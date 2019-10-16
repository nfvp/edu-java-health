package pt.dlt.health.bl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pt.dlt.health.dal.PatientDAL;
import pt.dlt.health.dto.Patient;
import pt.dlt.health.exception.NoPatientFoundException;

@Controller
public class PatientBL {

	private @Autowired PatientDAL patientDAL;

	public List<Patient> getListPatient() {
		return patientDAL.getListPatient();
	}

	public Patient createPatient(Patient p) {
		return patientDAL.createPatient(p);
	}

	public Patient getPatient(Long id) throws NoPatientFoundException {
		return patientDAL.getPatient(id);
	}

	public Patient updatePatient(Patient p) throws NoPatientFoundException {
		return patientDAL.updatePatient(p);
	}

	public void deletePatient(Long id) throws NoPatientFoundException {
        patientDAL.deletePatient(id);
	}
	
}
