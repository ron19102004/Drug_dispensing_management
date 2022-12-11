package controller;

import view.componentsView.Menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenubarController implements ActionListener {
    private Menubar menubar;
    public MenubarController(Menubar menubar){
        this.menubar = menubar;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Exit")){
            System.exit(1);
        }
    }
}
