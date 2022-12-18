package actionListener;

import database.JDBCUtil;
import view.LoginForm;
import view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class LoginAL implements ActionListener {
    private LoginForm loginForm;
    public LoginAL(LoginForm loginForm){
        this.loginForm = loginForm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.loginForm.getUsername().isBlank()&&Arrays.toString(this.loginForm.getPassword()).equals("[]")) {
            JFrame error = new JFrame("Cảnh báo lỗi");
            JOptionPane.showMessageDialog(error, "Vui lòng điền đầy đủ tên đăng nhập và mật khẩu !!!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if(this.loginForm.getUsername().isBlank()){
            JFrame error = new JFrame("Cảnh báo lỗi");
            JOptionPane.showMessageDialog(error,"Vui lòng điền tên đăng nhập !!!","Error",JOptionPane.ERROR_MESSAGE);
        } else if (Arrays.toString(this.loginForm.getPassword()).equals("[]")) {
            JFrame error = new JFrame("Cảnh báo lỗi");
            JOptionPane.showMessageDialog(error,"Vui lòng điền mật khẩu !!!","Error",JOptionPane.ERROR_MESSAGE);
        } else {
            String password = null;
            try {
                Connection connection = JDBCUtil.getConnection();
                String sql = "select (password_manage) from account_manage where username = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,this.loginForm.getUsername().trim());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                      password = resultSet.getNString("password_manage");
                }
                JDBCUtil.closeConnection(connection);
            } catch (SQLException ex){
                ex.getStackTrace();
            }
            if (password == null){
                JFrame error = new JFrame("Cảnh báo lỗi");
                JOptionPane.showMessageDialog(error,"Tên đăng nhập sai. Vui lòng thử lại !!!","Error",JOptionPane.ERROR_MESSAGE);
            } else {
                if (Arrays.equals(this.loginForm.getPassword(),password.toCharArray())){
                    JFrame success = new JFrame("Thông báo");
                    JOptionPane.showMessageDialog(success,"Đăng nhập thành công. Hệ thống đã sẵn sàng sử dụng !!!","Success",JOptionPane.INFORMATION_MESSAGE);
                    this.loginForm.setVisible(false);
                    new MainView();
                } else {
                    JFrame error = new JFrame("Cảnh báo lỗi");
                    JOptionPane.showMessageDialog(error,"Mật khẩu đăng nhập sai. Vui lòng thử lại !!!","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
