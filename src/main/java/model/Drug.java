package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;
import javax.persistence.*;

@Entity
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 1000)
    private String name;
    @OneToMany(mappedBy = "drug")
    @JsonIgnore
    private Set<DrugInfo> drugInfos;

    public Drug() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DrugInfo> getDrugInfos() {
        return drugInfos;
    }

    public void setDrugInfos(Set<DrugInfo> drugInfos) {
        this.drugInfos = drugInfos;
    }
}
