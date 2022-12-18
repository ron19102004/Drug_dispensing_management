package model;

public class AllocationDetails {
    private int id_patient;
    private int id_drug;
    private String drug_dispensing_date;
    private int amount_drug;

    public AllocationDetails(int id_patient, int id_drug, int amount_drug, String drug_dispensing_date) {
        this.id_patient = id_patient;
        this.id_drug = id_drug;
        this.amount_drug = amount_drug;
        this.drug_dispensing_date = drug_dispensing_date;
    }

    public int getAmount_drug() {
        return amount_drug;
    }

    public void setAmount_drug(int amount_drug) {
        this.amount_drug = amount_drug;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public int getId_drug() {
        return id_drug;
    }

    public void setId_drug(int id_drug) {
        this.id_drug = id_drug;
    }

    public String getDrug_dispensing_date() {
        return drug_dispensing_date;
    }

    public void setDrug_dispensing_date(String drug_dispensing_date) {
        this.drug_dispensing_date = drug_dispensing_date;
    }
}
