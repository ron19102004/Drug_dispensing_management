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
    public int create(Drug drug) {
        return  0;
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
    public int delete(Drug drug) {
        return  0;
    }

    @Override
    public int update(Drug drug) {
        return 0;
    }

    public int updateMountDrug(Drug drug){
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "update drug set remainingAmount=? where id_drug =?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,drug.getRemainingMount());
            preparedStatement.setInt(2,drug.getId_drug());
            check = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
        return check;
    }
    @Override
    public ArrayList selectThrowCondition(String condition) {
        return null;
    }
}
