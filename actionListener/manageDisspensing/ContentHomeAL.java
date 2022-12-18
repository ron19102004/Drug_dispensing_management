package actionListener.manageDisspensing;

import view.componentsView.manageDispensing.ContentHome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContentHomeAL implements ActionListener {
    private ContentHome contentHome;
    public ContentHomeAL(ContentHome contentHome){
        this.contentHome = contentHome;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Tìm")){
            if(!(this.contentHome.getCccdTF().isBlank())&&(this.contentHome.getCccdTF().length()==12)){
                CardLayout cardLayout = (CardLayout) this.contentHome.getCard().getLayout();
                cardLayout.show(this.contentHome.getCard(),"info");
            } else {
                JFrame frame = new JFrame("Cảnh báo");
                JOptionPane.showConfirmDialog(frame,"Vui lòng nhập giá trị không rỗng hoặc có 12 kí tự ","Error",JOptionPane.DEFAULT_OPTION);
            }
        }
    }
}
