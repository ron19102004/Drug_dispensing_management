package model;

public class Patient {
    private String id_patient;
    private String name_patient;
    private String drug_content;
    private String drug_description;

    public Patient(String id_patient, String name_patient, String drug_content, String drug_description) {
        this.id_patient = id_patient;
        this.name_patient = name_patient;
        this.drug_content = drug_content;
        this.drug_description = drug_description;
    }

    public String getId_patient() {
        return id_patient;
    }

    public void setId_patient(String id_patient) {
        this.id_patient = id_patient;
    }

    public String getName_patient() {
        return name_patient;
    }

    public void setName_patient(String name_patient) {
        this.name_patient = name_patient;
    }

    public String getDrug_content() {
        return drug_content;
    }

    public void setDrug_content(String drug_content) {
        this.drug_content = drug_content;
    }

    public String getDrug_description() {
        return drug_description;
    }

    public void setDrug_description(String drug_description) {
        this.drug_description = drug_description;
    }
}
