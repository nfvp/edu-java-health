package pt.dlt.health;

import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pt.dlt.health.dto.Appointment;
import pt.dlt.health.dto.Doctor;
import pt.dlt.health.dto.Patient;
import pt.dlt.health.routing.DoctorRL;
import pt.dlt.health.routing.PatientRL;
import pt.dlt.health.routing.AppointmentRL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HealthApplicationTests {

	private @Autowired PatientRL patientRL;
	private @Autowired DoctorRL doctorRL;
	private @Autowired AppointmentRL appointmentRL;

	@Test
	public void testDoctorsEndpoint() {
		List<Doctor> doctors = doctorRL.getListDoctor();
		assertNotNull(doctors);
	}

	@Test
	public void testPatientsEndpoint() {
		List<Patient> patients = patientRL.getListPatient();
		assertNotNull(patients);
	}

	@Test
	public void testAppointmentsEndpoint() {
		List<Appointment> appointments = appointmentRL.getListAppointment();
		assertNotNull(appointments);
	}

}
