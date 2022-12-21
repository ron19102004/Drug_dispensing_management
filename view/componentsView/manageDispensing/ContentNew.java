package view.componentsView.manageDispensing;

import actionListener.manageDisspensing.ContentNewAL;
import controller.DrugController;
import dataAccessObject.DrugDAO;
import model.Drug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

public class ContentNew extends JPanel {
    private JPanel contentNew;
    private ActionListener actionListener;
    private JComboBox<Object> drug;
    private JTextField amount_drug;
    private Vector<Vector<java.io.Serializable>> data;

    public ContentNew(){
        this.contentNew = new JPanel();
        this.actionListener = new ContentNewAL(this);
        this.init();
    }
    public void init(){
        this.contentNew.setBorder(BorderFactory.createTitledBorder("Thêm thông tin cấp phát thuốc bệnh nhân"));
        Font font = new Font("Cascadia",Font.ITALIC,15);
        Font font_f = new Font("Cascadia",Font.BOLD,15);

        JPanel jPTitle = new JPanel(new GridLayout(5,1));
        JLabel name = new JLabel("Tên bệnh nhân ");name.setFont(font_f);
        JLabel CCCD = new JLabel("CCCD ");CCCD.setFont(font_f);
        JLabel phone = new JLabel("Số điện thoại ");phone.setFont(font_f);
        JLabel address = new JLabel("Địa chỉ ");address.setFont(font_f);
        JLabel sexPatient = new JLabel("Giới tính");sexPatient.setFont(font_f);

        jPTitle.add(name);
        jPTitle.add(CCCD);
        jPTitle.add(phone);
        jPTitle.add(address);
        jPTitle.add(sexPatient);


        JPanel jPInput= new JPanel(new GridLayout(5,1));
        JTextField jfName = new JTextField(10);jfName.setFont(font);
        JTextField jfCCCD = new JTextField(10);jfCCCD.setFont(font);
        JTextField jfPhone = new JTextField(10);jfPhone.setFont(font);
        JTextField jfAddress = new JTextField(10);jfAddress.setFont(font);
        Vector<Object> sex = new Vector<>();
        sex.add("Nam");sex.add("Nữ");sex.add("Khác");
        JComboBox<Object> sexSelection = new JComboBox<>(sex);sexSelection.setFont(font);

        jPInput.add(jfName);
        jPInput.add(jfCCCD);
        jPInput.add(jfPhone);
        jPInput.add(jfAddress);
        jPInput.add(sexSelection);

        JPanel formAddInfo = new JPanel(new BorderLayout());
        formAddInfo.setBorder(BorderFactory.createTitledBorder("Thông tin bệnh nhân"));
        formAddInfo.add(jPTitle,BorderLayout.WEST);
        formAddInfo.add(jPInput,BorderLayout.CENTER);

        JPanel formDrug = new JPanel(new GridLayout(1,2));
        formDrug.setBorder(BorderFactory.createTitledBorder("Thuốc cấp phát"));

        JPanel formDrugLeft = new JPanel();
        formDrugLeft.setLayout(new BoxLayout(formDrugLeft,BoxLayout.Y_AXIS));

        ArrayList<Drug> arrDrug = DrugController.getInstance().getDrugs();
        Vector<Object> nameDrug = new Vector<>();
        for(Drug drug : arrDrug){
            nameDrug.add(drug.getName_drug()+" - "+" Còn lại " + drug.getRemainingMount()+" sản phẩm");
        }
        this.drug = new JComboBox<>(nameDrug);
        this.drug.setFont(font_f);
        this.drug.setBorder(BorderFactory.createTitledBorder("Tên thuốc"));
        formDrugLeft.add(this.drug);

        this.amount_drug = new JTextField();
        this.amount_drug.setFont(font_f);
        this.amount_drug.setBorder(BorderFactory.createTitledBorder("Số lượng (số sản phẩm)"));
        formDrugLeft.add(this.amount_drug);

        this.data = new Vector<Vector<java.io.Serializable>>();
        Vector<java.io.Serializable> arow = new Vector<>();
        arow.add("HIHI");
        arow.add(1);
        Vector<java.io.Serializable> a1row = new Vector<>();
        a1row.add("HgHI");
        a1row.add(1);
        this.data.add(arow);
        this.data.add(a1row);

        JPanel jpAddDrug = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton listDrug = new JButton("Danh sách đã chọn");
        listDrug.setBackground(Color.darkGray);
        listDrug.setForeground(Color.WHITE);
        listDrug.setBorderPainted(false);
        jpAddDrug.add(listDrug);
        formDrugLeft.add(jpAddDrug);
        listDrug.addActionListener(this.actionListener);

        JButton addDrug = new JButton("Thêm thuốc");
        addDrug.setBackground(Color.darkGray);
        addDrug.setForeground(Color.WHITE);
        addDrug.setBorderPainted(false);
        jpAddDrug.add(addDrug);
        formDrugLeft.add(jpAddDrug);
        addDrug.addActionListener(this.actionListener);

        Vector<Object> dayNum = new Vector<>();
        for(int i = 1; i<=30; i++){
            dayNum.add(i);
        }
        JComboBox<Object> day = new JComboBox<>(dayNum);
        day.setFont(font_f);

        Vector<Object> monthNum = new Vector<>();
        for(int i = 1; i<=12; i++){
            monthNum.add(i);
        }
        JComboBox<Object> month = new JComboBox<>(monthNum);
        month.setFont(font_f);

        Vector<Object> yearNum = new Vector<>();
        Calendar calendar = Calendar.getInstance();
        for(int i = 1950; i<= calendar.get(Calendar.YEAR); i++){
            yearNum.add(i);
        }
        JComboBox<Object> year = new JComboBox<>(yearNum);
        year.setFont(font_f);

        JPanel dateDispensing = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dateDispensing.setBorder(BorderFactory.createTitledBorder("Ngày cấp thuốc"));
        dateDispensing.add(day);
        dateDispensing.add(month);
        dateDispensing.add(year);

        formDrug.add(formDrugLeft);
        formDrug.add(dateDispensing);

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton delInfo = new JButton("Xóa dữ liệu đã nhập");
        delInfo.setFont(font_f);
        delInfo.setBackground(Color.RED);
        delInfo.setForeground(Color.WHITE);
        delInfo.setBorderPainted(false);
        footer.add(delInfo);

        JButton submit = new JButton("Hoàn tất");
        submit.setFont(font_f);
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setBorderPainted(false);
        footer.add(submit);

        JPanel formNorth = new JPanel();
        formNorth.setLayout(new BoxLayout(formNorth,BoxLayout.Y_AXIS));
        formNorth.add(formAddInfo);
        formNorth.add(formDrug);

        this.contentNew.setLayout(new BorderLayout());
        this.contentNew.add(formNorth,BorderLayout.NORTH);
        this.contentNew.add(footer,BorderLayout.SOUTH);
    }

    public Vector<Vector<Serializable>> getData() {
        return data;
    }

    public JComboBox<Object> getDrug() {
        return drug;
    }

    public JTextField getAmount_drug() {
        return amount_drug;
    }

    public JPanel getContentNew() {
        return contentNew;
    }
}
