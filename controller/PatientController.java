package controller;


import dataAccessObject.PatientDAO;
import model.Patient;

import java.util.ArrayList;

public class PatientController {
    private ArrayList<Patient> PatientList;
    public static PatientController getInstance(){
        return new PatientController();
    }
    public void setPatientList(){
        this.PatientList = PatientDAO.getInstance().selectAll();
    }
    public ArrayList<Patient> getPatientList(){
        this.setPatientList();
        return this.PatientList;
    }
}
