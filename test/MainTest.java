package test;

import view.LoginForm;
import javax.swing.*;

public class MainTest {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new LoginForm();
//            new MainView();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
