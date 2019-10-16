package pt.dlt.health.bl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pt.dlt.health.dal.AppointmentDAL;
import pt.dlt.health.dto.Appointment;
import pt.dlt.health.exception.NoAppointmentFoundException;

@Controller
public class AppointmentBL {

	private @Autowired AppointmentDAL appointmentDAL;

	public List<Appointment> getListAppointment() {
		return appointmentDAL.getListAppointment();
	}

	public Appointment createAppointment(Appointment a) {
		return appointmentDAL.createAppointment(a);
	}

	public Appointment getAppointment(Long id) throws NoAppointmentFoundException {
		return appointmentDAL.getAppointment(id);
	}

	public Appointment updateAppointment(Appointment a) throws NoAppointmentFoundException {
		return appointmentDAL.updateAppointment(a);
	}

	public void deleteAppointment(Long id) throws NoAppointmentFoundException {
        appointmentDAL.deleteAppointment(id);
	}

}
