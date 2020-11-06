package pt.dlt.health.routing;

import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import pt.dlt.health.bl.MetricsBL;

@RestController
@RequestMapping("/api")
@Api(tags = "Metrics", value = "Metrics Routing Layer")
@CrossOrigin
public class MetricsRL {

    private Logger log = Logger.getLogger("Metric Layer");

    private @Autowired MetricsBL metricsBL;

    
    @GetMapping("/metrics/specialities/count")
    public Map<String, Integer> getDoctorSpecialitiesCount() {
        log.info("getDoctorSpecialitiesCount");
        return metricsBL.getDoctorSpecialitiesCount();
    }

}
