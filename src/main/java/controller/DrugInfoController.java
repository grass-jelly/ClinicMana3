package controller;

import model.DrugCountsDTO;
import model.DrugInfo;
import model.DrugNameCountsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DrugInfoService;

import java.util.List;

@RestController
@RequestMapping(
        path = {"/"}
)
public class DrugInfoController {
    @Autowired
    private DrugInfoService drugInfoService;

    @RequestMapping(
            path = {"drugInfos"},
            method = {RequestMethod.POST}
    )
    public DrugInfo addPrescriptionDrug(@RequestBody DrugInfo drugInfo) {
        return this.drugInfoService.addDrugInfo(drugInfo);
    }

    @RequestMapping(
            path = {"drugInfosByPrescription"},
            method = {RequestMethod.GET}
    )
    public List<DrugInfo> getDrugInfos(@RequestParam("prescriptionId") int prescriptionId) {
        return this.drugInfoService.getDrugInfos(prescriptionId);
    }

    @RequestMapping(path = "drugCounts", method = RequestMethod.GET)
    public List<DrugNameCountsDTO> getDrugCounts() {
        return this.drugInfoService.getDrugCounts();
    }
}
