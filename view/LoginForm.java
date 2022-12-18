package view;

import actionListener.LoginAL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField username;
    private JPasswordField password;
    public LoginForm(){
        this.init();
        this.setVisible(true);
    }
    private void init() {
        this.setTitle("Đăng nhập hệ thống ");
        this.setSize(400,200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("src/public/image/login/login.png");
        this.setIconImage(icon.getImage());
        Font fontTitle = new Font("Cascadia",Font.BOLD,30);
        Font fontText = new Font("Cascadia", Font.ITALIC,20);

        JLabel title = new JLabel("Quản Lý Cấp Phát Thuốc");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(fontTitle);

        JPanel jPanelUsername = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ImageIcon iconUser = new ImageIcon("src/public/image/login/Admin-icon.png");
        JLabel jLabelUsername = new JLabel("Username: ",iconUser,JLabel.CENTER);
        jLabelUsername.setFont(fontText);
        this.username = new JTextField(10);
        this.username.setFont(fontText);
        jPanelUsername.add(jLabelUsername);
        jPanelUsername.add(this.username);

        JPanel jPanelPassword = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ImageIcon iconPass = new ImageIcon("src/public/image/login/password-manager-icon.png");
        JLabel jLabelPassword = new JLabel("Password:  ",iconPass,JLabel.CENTER);
        jLabelPassword.setFont(fontText);
        this.password = new JPasswordField(10);
        this.password.setFont(fontText);
        jPanelPassword.add(jLabelPassword);
        jPanelPassword.add(this.password);

        ActionListener actionListener = new LoginAL(this);
        JButton submit = new JButton("Đăng nhập");
        submit.setForeground(Color.WHITE);
        submit.setBorderPainted(false);
        submit.setBackground(Color.BLUE);
        submit.setFont(fontText);
        submit.addActionListener(actionListener);

        JPanel formLog = new JPanel();
        formLog.setLayout(new BoxLayout(formLog,BoxLayout.Y_AXIS));
        formLog.add(jPanelUsername);
        formLog.add(jPanelPassword);

        this.setLayout(new BorderLayout());
        this.add(title,BorderLayout.NORTH);
        this.add(formLog,BorderLayout.CENTER);
        this.add(submit,BorderLayout.SOUTH);
    }
    public String getUsername(){
        return this.username.getText();
    }
    public char[] getPassword(){
        return this.password.getPassword();
    }
}
