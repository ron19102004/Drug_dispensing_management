package controller;

import dataAccessObject.DrugDAO;
import model.Drug;

import java.util.ArrayList;

public class DrugController {
    private ArrayList<Drug> drugs;
    public static DrugController getInstance(){
        return new DrugController();
    }
    public void setDrugs(){
        this.drugs = DrugDAO.getInstance().selectAll();
    }
    public ArrayList<Drug> getDrugs(){
        this.setDrugs();
        return this.drugs;
    }
}
