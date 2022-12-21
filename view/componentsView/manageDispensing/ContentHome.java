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
    private DefaultTableModel cols;
    private Vector<Vector<Serializable>> data;
    private JTable table;
    private JTextField cccdTF;
    private JPanel tb;
    private JPanel card;
    private JPanel infoOne;
    public ContentHome(){
        this.contentHome = new JPanel();
        this.actionListener = new ContentHomeAL(this);
        this.init();
    }
    public void init(){
        this.infoOne = new JPanel(new BorderLayout());
        this.tb = new JPanel(new BorderLayout());
        this.tb.setBorder(BorderFactory.createTitledBorder("Thông tin các bệnh nhân được cấp thuốc"));

        this.setCols();
        this.table = new JTable(this.cols);
        this.putData();
        this.table.setFont( new Font("Cascadia",Font.BOLD,17));
        this.table.setEnabled(false);
        this.table.setBackground(Color.PINK);
        this.table.setForeground(Color.BLACK);
        this.table.setOpaque(false);
        this.table.setRowHeight(50);
        this.table.getColumnModel().getColumn(0).setMinWidth(130);
        this.table.getColumnModel().getColumn(0).setMaxWidth(130);

        JTableHeader jTableHeader = table.getTableHeader();
        jTableHeader.setFont(new Font("Cascadia",Font.BOLD,18));
        jTableHeader.setBackground(Color.gray);
        jTableHeader.setForeground(Color.WHITE);
        jTableHeader.setOpaque(false);

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
        this.card.add("info",this.infoOne);
    }
    public JPanel getCard(){
        return this.card;
    }
    public void showFind(Patient patient){
        this.infoOne.setBorder(BorderFactory.createTitledBorder("Thông tin cấp phát bệnh nhân: " + patient.getName_patient()));

        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        JButton back = new JButton(new ImageIcon("src/public/image/homeDispense/Go-back-icon.png"));
        back.setActionCommand("back");
        back.addActionListener(this.actionListener);

        JPanel content = new JPanel();
        content.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        toolbar.add(back);
        this.infoOne.add(toolbar,BorderLayout.NORTH);
        this.infoOne.add(content,BorderLayout.CENTER);

    }

    private JPanel findOne(){
        JPanel findOne = new JPanel();
        findOne.setBorder(BorderFactory.createTitledBorder("Hiển thị thông tin cụ thể bệnh nhân theo CCCD"));

        Font font = new Font("Cascadia",Font.BOLD,20);
        JLabel cccd = new JLabel("Nhập số CCCD ");
        cccd.setFont(font);
        this.cccdTF = new JTextField(12);
        this.cccdTF.setFont(font);
        JButton submit = new JButton("Hiển thị");
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
        this.cols = new DefaultTableModel();
        this.cols.addColumn("CCCD");
        this.cols.addColumn("Tên");
    }
    public Vector<Vector<Serializable>> getData(){
        this.data = new Vector<Vector<Serializable>>();
        ArrayList<Patient> list = new PatientController().getPatientList();
        for(Patient ls : list){
            Vector<Serializable> v = new Vector<Serializable>();
            v.add(ls.getCccd_patient());
            v.add(ls.getName_patient());
            this.data.add(v);
        }
        return this.data;
    }
    public void putData(){
        this.getData();
        for(Vector<Serializable> item : this.data){
            this.cols.addRow(item);
        }
    }
    public void refreshTable(){
        Vector<Serializable> col = new Vector<>();
        for(int i = 0; i < this.cols.getColumnCount(); i++){
            col.add(this.cols.getColumnName(i));
        }
        this.table.setModel(new DefaultTableModel(this.getData(),col));
    }
    public JPanel getContentHome() {
        return contentHome;
    }
}
