package actionListener.manageDrug;

import view.MainView;
import view.componentsView.manageDrug.Content;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarManageDrugAL implements ActionListener {
    private JPanel content;
    private MainView mainView;
    public ToolbarManageDrugAL(JPanel content, MainView mainView){
        this.content = content;
        this.mainView = mainView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
