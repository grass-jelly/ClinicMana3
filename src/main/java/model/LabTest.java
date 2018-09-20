package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LabTest {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence-generator"
    )
    @SequenceGenerator(name = "sequence-generator", sequenceName = "labTest_sequence", allocationSize = 1)
    private int id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "LabTest_MedicalService",
            joinColumns = { @JoinColumn(name = "labTest_id") },
            inverseJoinColumns = { @JoinColumn(name = "medicalService_id") }
    )
    private Set<MedicalService> medicalServices;

    @OneToOne
    private Visit visit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<MedicalService> getMedicalServices() {
        return medicalServices;
    }

    public void setMedicalServices(Set<MedicalService> medicalServices) {
        this.medicalServices = medicalServices;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
}
