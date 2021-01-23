package pt.dlt.health.routing;

import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import pt.dlt.health.services.MetricService;

@RestController
@RequestMapping("/api")
@Api(tags = "Metric", value = "Metric Controller", description = "Controller for manipulating the entity \"Metric\"")
@CrossOrigin
public class MetricController {
    
    private Logger logger = Logger.getLogger("Routing Layer");
    
    private @Autowired MetricService metricService;
    
    
    @GetMapping("/metrics/specialities/count")
    public Map<String, Integer> getDoctorSpecialitiesCount() {
        logger.info("getDoctorSpecialitiesCount");
        return metricService.getDoctorSpecialitiesCount();
    }
    
}
