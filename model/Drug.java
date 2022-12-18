package model;

public class Drug {
    private int id_drug;
    private String name_drug;
    private String description_drug;
    private String drug_import_date;
    private int numberImport;
    private int remainingAmount;


    public Drug(int id_drug, String name_drug, String description_drug, String drug_import_date,int numberImport, int remainingAmount) {
        this.id_drug = id_drug;
        this.name_drug = name_drug;
        this.description_drug = description_drug;
        this.drug_import_date = drug_import_date;
        this.numberImport = numberImport;
        this.remainingAmount = remainingAmount;
    }

    public int getId_drug() {
        return id_drug;
    }

    public void setId_drug(int id_drug) {
        this.id_drug = id_drug;
    }

    public String getName_drug() {
        return name_drug;
    }

    public void setName_drug(String name_drug) {
        this.name_drug = name_drug;
    }

    public String getDescription_drug() {
        return description_drug;
    }

    public void setDescription_drug(String description_drug) {
        this.description_drug = description_drug;
    }

    public String getDrug_import_date() {
        return drug_import_date;
    }

    public void setDrug_import_date(String drug_import_date) {
        this.drug_import_date = drug_import_date;
    }

    public int getNumberImport() {
        return numberImport;
    }

    public void setNumberImport(int numberImport) {
        this.numberImport = numberImport;
    }

    public int getRemainingMount() {
        return remainingAmount;
    }

    public void setRemainingMount(int remainingAmount) {
        this.remainingAmount = remainingAmount;
    }
}
