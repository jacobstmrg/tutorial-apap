package apap.tutorial.haidokter.restcontroller;

import apap.tutorial.haidokter.service.APIRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HospitalRestController {

    @Autowired
    private APIRestService apiRestService;

    @GetMapping(value = "/hospitals/find")
    private String getHospital(
            @RequestParam(value = "state", required = true) String singkatanNegaraBagian) {
        return apiRestService.getHospitalByState(singkatanNegaraBagian);
    }
}