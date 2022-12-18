package view.componentsView.manageDispensing;

import javax.swing.*;
import java.awt.*;

public class ContentHome extends JPanel {
    private JPanel contentHome;
    public ContentHome(){
        this.contentHome = new JPanel();
        this.init();
    }
    public void init(){
        this.contentHome.setBackground(Color.GREEN);
    }

    public JPanel getContentHome() {
        return contentHome;
    }
}
