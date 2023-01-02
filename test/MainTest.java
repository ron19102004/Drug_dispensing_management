package test;

import view.LoginForm;
import view.MainView;

import javax.swing.*;
import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            new LoginForm();
            new MainView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

