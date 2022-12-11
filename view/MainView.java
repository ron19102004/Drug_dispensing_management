package view;

import view.componentsView.Menubar;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    public MainView(){
        this.init();
        this.setVisible(true);
    }

    private void init() {
        this.setTitle("Hệ thống quản lý cấp phát thuốc bệnh nhân");
        this.setSize(1200,700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src/public/image/main/medicine-box-2-icon.png");
        this.setIconImage(icon.getImage());

        JMenuBar jMenuBar = Menubar.getInstance().getJMenuBar();

        this.setLayout(new BorderLayout());
        this.add(jMenuBar,BorderLayout.NORTH);
    }
}
