package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @SequenceGenerator(name = "sequence-generator", sequenceName = "diagnosis_sequence", allocationSize = 1)
    private int id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Diagnosis_Disease", joinColumns = { @JoinColumn(name = "diagnosis_id") }, inverseJoinColumns = { @JoinColumn(name = "disease_id") })
    private Set<Disease> diseases;

    @OneToOne
    private Visit visit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(Set<Disease> diseases) {
        this.diseases = diseases;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
}
