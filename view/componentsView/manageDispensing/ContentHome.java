package view.componentsView.manageDispensing;

import actionListener.manageDisspensing.ContentHomeAL;
import controller.PatientController;
import model.Patient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class ContentHome extends JPanel {
    private ActionListener actionListener;
    private JPanel contentHome;
    private DefaultTableModel cols;
    private ArrayList<String[]> data;
    private JTable table;
    private JTextField cccdTF;
    private JPanel tb;
    private JPanel card;
    private JPanel infoOne;
    private ArrayList<Patient> list;
    private JTextField name, sex, address, cccd, phone;
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

        this.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               int selectRow = table.getSelectedRow();
                cccdTF.setText(data.get(selectRow)[0]);

            }
        });
        this.table.setFont( new Font("Cascadia",Font.BOLD,17));
        this.table.setBackground(Color.PINK);
        this.table.setForeground(Color.BLACK);
        this.table.setOpaque(false);
        this.table.setRowHeight(50);

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
        this.card.add("info",getInfoOne());
    }
    public JPanel getCard(){
        return this.card;
    }
    public JPanel getInfoOne(){
        this.infoOne.setBorder(BorderFactory.createTitledBorder("Thông tin cấp phát bệnh nhân chi tiết"));

        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        JButton back = new JButton(new ImageIcon("src/public/image/homeDispense/Go-back-icon.png"));
        back.setActionCommand("back");
        back.addActionListener(this.actionListener);

        JPanel content = new JPanel(new BorderLayout());
        content.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        //create font
        Font font = new Font("Arial",Font.BOLD,15);

        JPanel jPanelLabel = new JPanel(new GridLayout(5,1));

        JLabel jLabelName = new JLabel("Họ và tên: ");
        jLabelName.setFont(font);
        JLabel jLabelCCCD = new JLabel("Số căn cước công dân: ");
        jLabelCCCD.setFont(font);
        JLabel jLabelSex = new JLabel("Giới tính: ");
        jLabelSex.setFont(font);
        JLabel jLabelPhone = new JLabel("Số điện thoại: ");
        jLabelPhone.setFont(font);
        JLabel jLabelAddress = new JLabel("Địa chỉ: ");
        jLabelAddress.setFont(font);

        jPanelLabel.add(jLabelName);
        jPanelLabel.add(jLabelCCCD);
        jPanelLabel.add(jLabelSex);
        jPanelLabel.add(jLabelPhone);
        jPanelLabel.add(jLabelAddress);

        JPanel jPanelData = new JPanel(new GridLayout(5,1));

        this.name = new JTextField("");
        this.name.setFont(font);
        this.name.setEditable(false);
        this.cccd = new JTextField("");
        this.cccd.setFont(font);
        this.cccd.setEditable(false);
        this.sex = new JTextField("");
        this.sex.setFont(font);
        this.sex.setEditable(false);
        this.phone = new JTextField("");
        this.phone.setFont(font);
        this.phone.setEditable(false);
        this.address = new JTextField("");
        this.address.setFont(font);
        this.address.setEditable(false);

        jPanelData.add(this.name);
        jPanelData.add(this.cccd);
        jPanelData.add(this.sex);
        jPanelData.add(this.phone);
        jPanelData.add(this.address);

        JPanel info = new JPanel(new GridLayout(1,2));
        info.add(jPanelLabel);
        info.add(jPanelData);

        content.add(info,BorderLayout.NORTH);

        toolbar.add(back);
        this.infoOne.add(toolbar,BorderLayout.NORTH);
        this.infoOne.add(content,BorderLayout.CENTER);
        return this.infoOne;
    }
    public void setInfoOne(Patient patient){
        this.name.setText(patient.getName_patient());
        this.phone.setText(patient.getPhone_patient());
        this.sex.setText(patient.getSex());
        this.address.setText(patient.getAddress_patient());
        this.cccd.setText(patient.getCccd_patient());
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

    public void setCccdTF(String cccdTF) {
        this.cccdTF.setText(cccdTF);
    }

    private void setCols(){
        this.cols = new DefaultTableModel();
        this.cols.addColumn("CCCD");
        this.cols.addColumn("Tên");
    }
    public ArrayList<String[]> getData(){
        this.data = new ArrayList<String[]>();
        this.list = new PatientController().getPatientList();
        for(Patient ls : this.list){
            String[] dt = {ls.getCccd_patient(),ls.getName_patient()};
            this.data.add(dt);
        }
        return this.data;
    }
    public void putData(){
        this.getData();
        for(String[] item : this.data){
            this.cols.addRow(item);
        }
    }
    public void refreshTable(){
        String[] col = {"CCCD","Tên"};
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(col);
        for(String[] data : this.getData()){
            defaultTableModel.addRow(data);
        }
        this.table.setModel(defaultTableModel);
    }
    public JPanel getContentHome() {
        return contentHome;
    }
}
