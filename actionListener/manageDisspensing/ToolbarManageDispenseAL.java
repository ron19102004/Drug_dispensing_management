package actionListener.manageDisspensing;

import controller.PatientController;
import view.componentsView.manageDispensing.Content;
import view.componentsView.manageDispensing.ContentHome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarManageDispenseAL implements ActionListener {
    private JPanel jpContent;
    private Content content;
    public ToolbarManageDispenseAL(JPanel jpContent, Content content){
        this.jpContent = jpContent;
        this.content = content;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("home")){
            CardLayout home = (CardLayout) this.jpContent.getLayout();
            home.show(this.jpContent,"home");
        } else if (src.equals("new")) {
            CardLayout create = (CardLayout) this.jpContent.getLayout();
            create.show(this.jpContent,"new");
        } else if (src.equals("edit")) {
            CardLayout edit = (CardLayout) this.jpContent.getLayout();
            edit.show(this.jpContent,"edit");
        } else if (src.equals("refresh")) {
            this.content.getContentHome().refreshTable();
        }
    }
}
