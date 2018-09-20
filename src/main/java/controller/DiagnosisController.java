package controller;

import model.Diagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.DiagnosisService;

import java.util.List;

@RestController
@RequestMapping(path = {"/"})
public class DiagnosisController {
    @Autowired
    private DiagnosisService diagnosisService;

    @RequestMapping(
            path = {"diagnoses"},
            method = {RequestMethod.POST}
    )
    public Diagnosis addDiagnosis(@RequestBody Diagnosis diagnosis) {
        return this.diagnosisService.addDiagnosis(diagnosis);
    }

    @RequestMapping(
            path = {"diagnoses"},
            method = {RequestMethod.GET}
    )
    public List<Diagnosis> getDiagnoses() {
        return this.diagnosisService.getAllDiagnoses();
    }

}
