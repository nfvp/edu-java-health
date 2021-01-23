package pt.dlt.health.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.dlt.health.dto.Doctor;

@Service
public class MetricService {
    
    private @Autowired DoctorService doctorService;
    
    
    public Map<String, Integer> getDoctorSpecialitiesCount() {
        List<Doctor> doctors = doctorService.getListDoctor();
        Map<String, Integer> specialities = new HashMap<>();
        for (Doctor d : doctors) {
            String speciality = d.getSpeciality().name();
            if (specialities.containsKey(speciality)) {
                int count = specialities.get(speciality);
                specialities.put(speciality, ++count);
            } else {
                specialities.put(speciality, 1);
            }
        }
        return specialities;
    }
    
}
