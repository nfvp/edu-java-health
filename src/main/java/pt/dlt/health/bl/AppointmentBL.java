package pt.dlt.health.bl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pt.dlt.health.dal.AppointmentDAL;
import pt.dlt.health.dto.Appointment;

@Controller
public class AppointmentBL {

    private @Autowired AppointmentDAL appointmentDAL;

    public List<Appointment> getListAppointment() {
        return appointmentDAL.getListAppointment();
    }

	public Appointment createAppointment(Appointment a) {
		return appointmentDAL.createAppointment(a);
	}

	public Appointment getAppointment(Long id) {
		return appointmentDAL.getAppointment(id);
	}

	public void deleteAppointment(Long id) {
        appointmentDAL.deleteAppointment(id);
	}

}
