package dataAccessObject;

import database.JDBCUtil;
import model.Drug;
import model.Patient;

import java.sql.*;
import java.util.ArrayList;

public class DrugDAO implements DataAccessObject<Drug>{
    public static DrugDAO getInstance(){
        return new DrugDAO();
    }

    @Override
    public void create(Drug drug) {

    }

    @Override
    public ArrayList<Drug> selectAll() {
        ArrayList<Drug> listAllDrug = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql ="select * from drug";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id_drug = resultSet.getInt("id_drug");
                String name_drug = resultSet.getNString("name_drug");
                String description_drug = resultSet.getNString("description_drug");
                Date drug_import_date = resultSet.getDate("drug_import_date");
                int numberImport = resultSet.getInt("numberImport");
                int remainingAmount = resultSet.getInt("remainingAmount");
                Drug drug = new Drug(id_drug,name_drug,description_drug,drug_import_date.toString(),numberImport,remainingAmount);
                listAllDrug.add(drug);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
        return listAllDrug;
    }

    @Override
    public void delete(Drug drug) {

    }

    @Override
    public void update(Drug drug) {

    }

    @Override
    public ArrayList selectThrowCondition(String condition) {
        return null;
    }
}
