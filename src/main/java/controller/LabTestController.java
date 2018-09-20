package controller;

import model.LabTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.LabTestService;

import java.util.List;

@RestController
@RequestMapping(
        path = {"/"}
)
public class LabTestController {
    @Autowired
    private LabTestService labTestService;

    @RequestMapping(
            path = {"labTests"},
            method = {RequestMethod.POST}
    )
    public LabTest addLabTest(@RequestBody LabTest labTest) {
        return this.labTestService.addLabTest(labTest);
    }

    @RequestMapping(
            path = {"labTests"},
            method = {RequestMethod.GET}
    )
    public List<LabTest> getLabTests() {
        return this.labTestService.getAllLabTests();
    }

}
