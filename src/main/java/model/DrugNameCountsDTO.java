package model;

public class DrugNameCountsDTO {
    private String drugName;
    private Long count;

    public DrugNameCountsDTO(String name, Long count) {
        this.drugName = name;
        this.count = count;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
