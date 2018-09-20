package controller;

import java.util.List;
import model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.PrescriptionService;

@RestController
@RequestMapping(
        path = {"/"}
)
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    public PrescriptionController() {
    }

    @RequestMapping(
            path = {"prescriptions"},
            method = {RequestMethod.POST}
    )
    public int addPrescription(@RequestBody Prescription prescription) {
        return this.prescriptionService.addPrescription(prescription);
    }

    @RequestMapping(
            path = {"prescriptions"},
            method = {RequestMethod.GET}
    )
    public List<Prescription> getPrescriptions() {
        return this.prescriptionService.getAllPrescriptions();
    }

    @RequestMapping(
            path = {"prescriptions/{id}"},
            method = {RequestMethod.GET}
    )
    public Prescription getPrescription(@PathVariable int id) {
        return this.prescriptionService.getPrescription(id);
    }
}
