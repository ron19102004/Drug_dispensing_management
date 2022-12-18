package view;

import actionListener.manageDisspensing.ToolbarManageDispenseAL;
import actionListener.manageDrug.ToolbarManageDrugAL;
import view.componentsView.manageDispensing.Content;
import view.componentsView.Menubar;
import view.componentsView.ToolBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    public MainView(){
        this.init();
        this.setVisible(true);
    }

    private void init() {
        this.setTitle("Hệ thống quản lý cấp phát thuốc bệnh nhân");
        this.setSize(1000,600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src/public/image/main/medicine-box-2-icon.png");
        this.setIconImage(icon.getImage());

        //Manage Dispensing
        JPanel jpContent = new Content().getContent();
        ActionListener toolbarManageDispenseAL = new ToolbarManageDispenseAL(jpContent);
        JPanel main = new JPanel(new BorderLayout());
        main.add(new ToolBar(toolbarManageDispenseAL).init(),BorderLayout.WEST);
        main.add(jpContent,BorderLayout.CENTER);

        JPanel jPanelMD = new view.componentsView.manageDrug.Content().getContent();
        ActionListener toolbarManageDrug = new ToolbarManageDrugAL(jPanelMD);
        JPanel manageDrug = new JPanel(new BorderLayout());
        manageDrug.add(new ToolBar(toolbarManageDrug).init(),BorderLayout.WEST);
        manageDrug.add(main,BorderLayout.CENTER);

        JPanel jpWrapper= new JPanel(new CardLayout());
        jpWrapper.add("main",main);
        jpWrapper.add("manageDrug",manageDrug);

        JMenuBar jMenuBar = Menubar.getInstance(jpWrapper).getJMenuBar();

        this.setLayout(new BorderLayout());
        this.add(jMenuBar,BorderLayout.NORTH);
        this.add(jpWrapper,BorderLayout.CENTER);
    }
}
