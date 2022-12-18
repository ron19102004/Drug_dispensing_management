package actionListener.manageDisspensing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarManageDispenseAL implements ActionListener {
    private JPanel content;
    public ToolbarManageDispenseAL(JPanel content){
        this.content = content;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("home")){
            CardLayout home = (CardLayout) this.content.getLayout();
            home.show(this.content,"home");
        } else if (src.equals("new")) {
            CardLayout create = (CardLayout) this.content.getLayout();
            create.show(this.content,"new");
        } else if (src.equals("edit")) {
            CardLayout edit = (CardLayout) this.content.getLayout();
            edit.show(this.content,"edit");
        }
    }
}
