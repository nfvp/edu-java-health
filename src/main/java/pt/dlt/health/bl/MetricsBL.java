package pt.dlt.health.bl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.dlt.health.dal.DoctorDAL;
import pt.dlt.health.dto.Doctor;

@Component
public class MetricsBL {

    private @Autowired DoctorDAL doctorDAL;

    public Map<String, Integer> getDoctorSpecialitiesCount() {
        List<Doctor> doctors = doctorDAL.getListDoctor();
        Map<String, Integer> specialities = new HashMap<>();
        for (Doctor d : doctors) {
            // TO DO group doctors by specialities 
            d.toString();
        }
        return specialities;
    }

}
