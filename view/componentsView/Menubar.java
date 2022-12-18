package view.componentsView;

import actionListener.MenubarAL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Menubar extends JMenuBar {
    private JMenuBar jMenuBar;
    private JPanel jpWrapper;
    private ActionListener actionListener;
    public static Menubar getInstance(JPanel jpWrapper){
        return new Menubar(jpWrapper);
    }
    public Menubar(JPanel jpWrapper){
        this.jpWrapper = jpWrapper;
        this.actionListener = new MenubarAL(this);
        Font font = new Font("Cascadia",Font.BOLD,15);
        this.jMenuBar = new JMenuBar();
        this.jMenuBar.add(this.jMenuFile(font));
        this.jMenuBar.add(this.jMenuEdit(font));
        this.jMenuBar.add(this.jMenuView(font));
        JSeparator jSeparator = new JSeparator();
        jSeparator.getOrientation();
        this.jMenuBar.add(jSeparator);
    }
    public JMenuBar getJMenuBar(){
        return this.jMenuBar;
    }
    private JMenu jMenuFile(Font font){
        JMenu jMenuFile = new JMenu("Quản lý");
        jMenuFile.setFont(font);

        JMenuItem manageDispensing = new JMenuItem("Quản lý cấp phát thuốc");
        manageDispensing.setFont(font);
        manageDispensing.addActionListener(this.actionListener);

        JMenuItem manageDrug = new JMenuItem("Quản lý thuốc trong kho");
        manageDrug.setFont(font);
        manageDrug.addActionListener(this.actionListener);

        JMenuItem exit = new JMenuItem("Thoát",new ImageIcon("src/public/image/menu/Button-Close-icon.png"));
        exit.setFont(font);
        exit.addActionListener(this.actionListener);

        jMenuFile.add(manageDispensing);
        jMenuFile.add(manageDrug);
        jMenuFile.add(new JSeparator());
        jMenuFile.add(exit);
        return jMenuFile;
    }
    private JMenu jMenuEdit(Font font){
        JMenu jMenuEdit = new JMenu("Chỉnh sửa");
        jMenuEdit.setFont(font);
        return jMenuEdit;
    }
    private JMenu jMenuView(Font font) {
        JMenu jMenuView = new JMenu("Giao diện");
        jMenuView.setFont(font);
        JMenuItem refresh = new JMenuItem("Làm mới",new ImageIcon("src/public/image/menu/reload-2-icon.png"));
        refresh.setFont(font);
        jMenuView.add(refresh);
        return jMenuView;
    }

    public JPanel getJpWrapper() {
        return jpWrapper;
    }
    public void setJpWrapper(JPanel jpWrapper) {
        this.jpWrapper = jpWrapper;
    }
}
