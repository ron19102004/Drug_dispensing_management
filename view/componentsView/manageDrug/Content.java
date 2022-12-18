package view.componentsView.manageDrug;

import view.componentsView.manageDispensing.ContentEdit;
import view.componentsView.manageDispensing.ContentHome;
import view.componentsView.manageDispensing.ContentNew;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {
    private JPanel content;
    private ContentHome contentHome;
    private ContentEdit contentEdit;
    private ContentNew contentNew;
    public Content(){
        this.content = new JPanel();
        this.contentHome = new ContentHome();
        this.contentEdit = new ContentEdit();
        this.contentNew = new ContentNew();
        this.init();
    }
    public void init(){
        this.content.setLayout(new CardLayout());
        this.content.add("home",this.contentHome.getContentHome());
        this.content.add("new",this.contentNew.getContentNew());
        this.content.add("edit",this.contentEdit.getContentEdit());
    }
    public JPanel getContent() {
        return this.content;
    }
}
