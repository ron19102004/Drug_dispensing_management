package actionListener;

import view.componentsView.Menubar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenubarAL implements ActionListener {
    private Menubar menubar;
    public MenubarAL(Menubar menubar){
        this.menubar = menubar;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Thoát")){
            System.exit(1);
        } else if (src.equals("Quản lý thuốc trong kho")) {
            CardLayout cardLayout = (CardLayout) this.menubar.getJpWrapper().getLayout();
            cardLayout.show(this.menubar.getJpWrapper(),"manageDrug");
        } else if (src.equals("Quản lý cấp phát thuốc")) {
            CardLayout cardLayout = (CardLayout) this.menubar.getJpWrapper().getLayout();
            cardLayout.show(this.menubar.getJpWrapper(),"main");
        }
    }
}
