package view.componentsView.manageDispensing;

import actionListener.manageDisspensing.ContentHomeAL;
import controller.PatientController;
import model.Patient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class ContentHome extends JPanel {
    private ActionListener actionListener;
    private JPanel contentHome;
    private Vector<Object> cols;
    private Vector<Vector<Serializable>> rows;
    private JTable table;
    private JTextField cccdTF;
    private JPanel tb;
    private JPanel card;
    public ContentHome(){
        this.contentHome = new JPanel();
        this.actionListener = new ContentHomeAL(this);
        this.init();
    }
    public void init(){
        this.tb = new JPanel(new BorderLayout());
        this.tb.setBorder(BorderFactory.createTitledBorder("Thông tin các bệnh nhân được cấp thuốc"));

        this.table = new JTable(this.getRows(),this.getCols());
        this.table.setFont( new Font("Cascadia",Font.BOLD,13));
        this.table.setEnabled(false);

        JTableHeader jTableHeader = table.getTableHeader();
        jTableHeader.setFont(new Font("Cascadia",Font.BOLD,15));
        jTableHeader.setBackground(Color.BLUE);
        jTableHeader.setForeground(Color.BLACK);

        JScrollPane jScrollPane = new JScrollPane(table);

        this.tb.add(jScrollPane,BorderLayout.CENTER);

        this.contentHome.setLayout(new BorderLayout());
        this.setCard();
        this.contentHome.add(this.getCard(),BorderLayout.CENTER);
        this.contentHome.add(this.findOne(),BorderLayout.NORTH);
    }
    private void setCard(){
        this.card = new JPanel(new CardLayout());
        this.card.add("table",this.tb);
        this.card.add("info",this.infoOne());
    }
    public JPanel getCard(){
        return this.card;
    }
    private JPanel infoOne(){
        JPanel infoOne = new JPanel();
        infoOne.setBackground(Color.blue);
        return infoOne;
    }
    private JPanel findOne(){
        JPanel findOne = new JPanel();
        findOne.setBorder(BorderFactory.createTitledBorder("Hiển thị thông tin cụ thể bệnh nhân theo CCCD"));

        Font font = new Font("Cascadia",Font.BOLD,20);
        JLabel cccd = new JLabel("Nhập số CCCD ");
        cccd.setFont(font);
        this.cccdTF = new JTextField(12);
        this.cccdTF.setFont(font);
        JButton submit = new JButton("Tìm");
        submit.setFont(font);
        submit.setBorderPainted(false);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this.actionListener);

        findOne.setLayout(new FlowLayout());
        findOne.add(cccd);
        findOne.add(cccdTF);
        findOne.add(submit);

        return findOne;
    }

    public String getCccdTF() {
        return this.cccdTF.getText();
    }

    private void setCols(){
        cols = new Vector<>();
        cols.add("CCCD");
        cols.add("Tên");
    }
    private Vector<Object> getCols(){
        this.setCols();
        return this.cols;
    }
    public void setRows(){
        this.rows = new Vector<Vector<Serializable>>();
        ArrayList<Patient> list = new PatientController().getPatientList();
        for(Patient ls : list){
            Vector<Serializable> v = new Vector<Serializable>();
            v.add(ls.getCccd_patient());
            v.add(ls.getName_patient());
            this.rows.add(v);
        }
    }

    private Vector<Vector<Serializable>> getRows() {
        this.setRows();
        return rows;
    }
    public void refreshTable(){
        this.table.setModel(new DefaultTableModel(this.getRows(),this.cols));
    }
    public JPanel getContentHome() {
        return contentHome;
    }
}
