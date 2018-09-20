package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import javax.persistence.*;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @SequenceGenerator(name = "sequence-generator", sequenceName = "visit_sequence", allocationSize = 1)
    private int id;
    @ManyToOne
    private Patient patient;
    @Column
    private String date;
    @Column
    private String time;
    @Column
    private String problems;
    @OneToOne(mappedBy = "visit", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Prescription prescription;
    @OneToOne(mappedBy = "visit", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private LabTest labTest;
    @OneToOne(mappedBy = "visit", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Diagnosis diagnosis;
    @Column
    private boolean checkedOut;

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public Prescription getPrescription() {
        return this.prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getProblems() {
        return this.problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }

    public LabTest getLabTest() {
        return labTest;
    }

    public void setLabTest(LabTest labTest) {
        this.labTest = labTest;
    }

    public Visit() {
    }
}
