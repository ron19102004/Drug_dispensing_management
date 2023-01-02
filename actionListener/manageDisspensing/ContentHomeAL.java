package actionListener.manageDisspensing;

import dataAccessObject.PatientDAO;
import model.Patient;
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
        if(src.equals("Hiển thị")){
            if(!(this.contentHome.getCccdTF().isBlank())
                    &&(this.contentHome.getCccdTF().length()==12)
                    &&(this.isDigits(this.contentHome.getCccdTF()))){
                this.contentHome.setInfoOne(PatientDAO.getInstance().findOneByCCCD(this.contentHome.getCccdTF()));
                CardLayout cardLayout = (CardLayout) this.contentHome.getCard().getLayout();
                cardLayout.show(this.contentHome.getCard(),"info");
            } else {
                JFrame frame = new JFrame("Cảnh báo");
                JOptionPane.showConfirmDialog(frame,"Vui lòng nhập giá trị không rỗng hoặc có 12 kí tự ","Error",JOptionPane.DEFAULT_OPTION);
            }
        }
        else if (src.equals("back")){
            this.contentHome.setCccdTF("");
            CardLayout cardLayout = (CardLayout) this.contentHome.getCard().getLayout();
            cardLayout.show(this.contentHome.getCard(),"table");
        }
    }
    private boolean isDigits(String str){
        return str.matches("\\d+");
    }
}
