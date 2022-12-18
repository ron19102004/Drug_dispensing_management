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
            String sql ="insert into patient(name_patient,cccd_patient,phone_patient,address_patient) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,patient.getName_patient());
            preparedStatement.setString(2,patient.getCccd_patient());
            preparedStatement.setString(3,patient.getPhone_patient());
            preparedStatement.setString(4,patient.getAddress_patient());
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
                int id_patient = resultSet.getInt("id_patient");
                String name_patient = resultSet.getNString("name_patient");
                String cccd_patient = resultSet.getNString("cccd_patient");
                String phone_patient = resultSet.getNString("phone_patient");
                String address_patient = resultSet.getNString("address_patient");
                Patient patient = new Patient(id_patient,name_patient,cccd_patient,phone_patient,address_patient);
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
            preparedStatement.setInt(1,patient.getId_patient());
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
            String sql = "update patient set name_patient=?,cccd_patient=?,phone_patient=?,address_patient=? where id_patient=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,patient.getName_patient());
            preparedStatement.setString(2,patient.getCccd_patient());
            preparedStatement.setString(3,patient.getPhone_patient());
            preparedStatement.setString(4,patient.getAddress_patient());
            preparedStatement.setInt(5,patient.getId_patient());
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
                int id_patient = resultSet.getInt("id_patient");
                String name_patient = resultSet.getNString("name_patient");
                String cccd_patient = resultSet.getNString("cccd_patient");
                String phone_patient = resultSet.getNString("phone_patient");
                String address_patient = resultSet.getNString("address_patient");
                Patient patient = new Patient(id_patient,name_patient,cccd_patient,phone_patient,address_patient);
                listPatientThrowCondition.add(patient);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
        return listPatientThrowCondition;
    }
}
