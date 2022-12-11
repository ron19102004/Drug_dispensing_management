package view.componentsView;

import controller.MenubarController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Menubar extends JMenuBar {
    private JMenuBar jMenuBar;
    private ActionListener actionListener;
    public static Menubar getInstance(){
        return new Menubar();
    }
    public Menubar(){
        this.actionListener = new MenubarController(this);
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
        JMenu jMenuFile = new JMenu("File");
        jMenuFile.setFont(font);

        JMenuItem exit = new JMenuItem("Exit",new ImageIcon("src/public/image/menu/Button-Close-icon.png"));
        exit.setFont(font);
        exit.addActionListener(this.actionListener);

        jMenuFile.add(exit);
        return jMenuFile;
    }
    private JMenu jMenuEdit(Font font){
        JMenu jMenuEdit = new JMenu("Edit");
        jMenuEdit.setFont(font);
        return jMenuEdit;
    }
    private JMenu jMenuView(Font font) {
        JMenu jMenuView = new JMenu("View");
        jMenuView.setFont(font);
        JMenuItem refresh = new JMenuItem("Refresh",new ImageIcon("src/public/image/menu/reload-2-icon.png"));
        refresh.setFont(font);
        jMenuView.add(refresh);
        return jMenuView;
    }

}
