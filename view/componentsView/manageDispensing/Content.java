package view.componentsView.manageDispensing;

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

    public ContentHome getContentHome() {
        return contentHome;
    }

    public ContentEdit getContentEdit() {
        return contentEdit;
    }

    public ContentNew getContentNew() {
        return contentNew;
    }

    public JPanel getContent() {
        return this.content;
    }
}
