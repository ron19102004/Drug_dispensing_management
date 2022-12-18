package model;

public class Patient {
    private int id_patient;
    private String name_patient;
    private String cccd_patient;
    private String phone_patient;
    private String address_patient;

    public Patient(int id_patient, String name_patient, String cccd_patient, String phone_patient, String address_patient) {
        this.id_patient = id_patient;
        this.name_patient = name_patient;
        this.cccd_patient = cccd_patient;
        this.phone_patient = phone_patient;
        this.address_patient = address_patient;
    }
    public String getCccd_patient() {
        return cccd_patient;
    }

    public void setCccd_patient(String cccd_patient) {
        this.cccd_patient = cccd_patient;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public String getName_patient() {
        return name_patient;
    }

    public void setName_patient(String name_patient) {
        this.name_patient = name_patient;
    }

    public String getPhone_patient() {
        return phone_patient;
    }

    public void setPhone_patient(String phone_patient) {
        this.phone_patient = phone_patient;
    }

    public String getAddress_patient() {
        return address_patient;
    }

    public void setAddress_patient(String address_patient) {
        this.address_patient = address_patient;
    }
}
