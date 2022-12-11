package dataAccessObject;

import database.JDBCUtil;
import model.Patient;

import java.sql.*;
import java.util.ArrayList;

public class PatientDAO implements DataAccessObject<Patient>{
    public static PatientDAO getInstance(){
        return new PatientDAO();
    }
    @Override
    public void create(Patient patient) {
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql ="insert into patient(id_patient,name_patient,drug_content,drug_description) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,patient.getId_patient());
            preparedStatement.setString(2,patient.getName_patient());
            preparedStatement.setString(3,patient.getDrug_content());
            preparedStatement.setString(4,patient.getDrug_description());

            int check = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
    }

    @Override
    public ArrayList<Patient> selectAll() {
        ArrayList<Patient> listAllPatient = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql ="select * from patient";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String id_patient = resultSet.getNString("id_patient");
                String name_patient = resultSet.getNString("name_patient");
                String drug_content = resultSet.getNString("drug_content");
                String drug_description = resultSet.getNString("drug_description");
                Patient patient = new Patient(id_patient,name_patient,drug_content,drug_description);
                listAllPatient.add(patient);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
        return listAllPatient;
    }

    @Override
    public void delete(Patient patient) {
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql ="delete from patient where id_patient=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,patient.getId_patient());
            int check = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
    }

    @Override
    public void update(Patient patient) {
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "update patient set id_patient=?,name_patient=?,drug_content=?,drug_description=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,patient.getId_patient());
            preparedStatement.setString(2,patient.getName_patient());
            preparedStatement.setString(3,patient.getDrug_content());
            preparedStatement.setString(4,patient.getDrug_description());
            int check = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
    }

    @Override
    public ArrayList<Patient> selectThrowCondition(String condition) {
        ArrayList<Patient> listPatientThrowCondition = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql ="select * from patient where";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String id_patient = resultSet.getNString("id_patient");
                String name_patient = resultSet.getNString("name_patient");
                String drug_content = resultSet.getNString("drug_content");
                String drug_description = resultSet.getNString("drug_description");
                Patient patient = new Patient(id_patient,name_patient,drug_content,drug_description);
                listPatientThrowCondition.add(patient);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
        return listPatientThrowCondition;
    }
}
