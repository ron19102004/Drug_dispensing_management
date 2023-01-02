package view.componentsView.manageDispensing;

import actionListener.manageDisspensing.ContentNewAL;
import controller.DrugController;
import dataAccessObject.DrugDAO;
import model.AllocationDetails;
import model.Drug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

public class ContentNew extends JPanel {
    private JPanel contentNew;
    private ActionListener actionListener;
    private JComboBox<Object> drug;
    private JTextField amount_drug;
    private ArrayList<String[]> dataDrugSelected;
    private JTextField jfAddress, jfPhone,jfCCCD, jfName, day;
    private JComboBox<Object> sexSelection;
    private JComboBox<Integer> year,month;
    private ArrayList<Drug> arrDrug;

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
        this.jfName = new JTextField(10);this.jfName.setFont(font);
        this.jfCCCD = new JTextField(10);this.jfCCCD.setFont(font);
        this.jfPhone = new JTextField(10);this.jfPhone.setFont(font);
        this.jfAddress = new JTextField(10);this.jfAddress.setFont(font);
        Vector<Object> sex = new Vector<>();
        sex.add("Nam");sex.add("Nữ");sex.add("Khác");
        this.sexSelection = new JComboBox<>(sex);this.sexSelection.setFont(font);

        jPInput.add(this.jfName);
        jPInput.add(this.jfCCCD);
        jPInput.add(this.jfPhone);
        jPInput.add(this.jfAddress);
        jPInput.add(sexSelection);

        JPanel formAddInfo = new JPanel(new BorderLayout());
        formAddInfo.setBorder(BorderFactory.createTitledBorder("Thông tin bệnh nhân"));
        formAddInfo.add(jPTitle,BorderLayout.WEST);
        formAddInfo.add(jPInput,BorderLayout.CENTER);

        JPanel formDrug = new JPanel(new GridLayout(1,2));
        formDrug.setBorder(BorderFactory.createTitledBorder("Thuốc cấp phát"));

        JPanel formDrugLeft = new JPanel();
        formDrugLeft.setLayout(new BoxLayout(formDrugLeft,BoxLayout.Y_AXIS));

        this.arrDrug = DrugController.getInstance().getDrugs();
        Vector<Object> nameDrug = new Vector<>();
        for(Drug drug : this.arrDrug){
            nameDrug.add(drug.getName_drug());
        }
        this.drug = new JComboBox<>(nameDrug);
        this.drug.setFont(font_f);
        this.drug.setBorder(BorderFactory.createTitledBorder("Tên thuốc"));
        formDrugLeft.add(this.drug);

        int i = this.drug.getSelectedIndex();
        JTextField remainingAmount = new JTextField();
        remainingAmount.setFont(font_f);
        remainingAmount.setEditable(false);
        remainingAmount.setBorder(BorderFactory.createTitledBorder("Số lượng sản phẩm còn trong kho"));
        remainingAmount.setText(this.arrDrug.get(i).getRemainingMount()+" sản phẩm");
        formDrugLeft.add(remainingAmount);
        this.drug.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int i = drug.getSelectedIndex();
                arrDrug = DrugDAO.getInstance().selectAll();
                remainingAmount.setText(arrDrug.get(i).getRemainingMount()+" sản phẩm");
            }
        });

        this.amount_drug = new JTextField();
        this.amount_drug.setFont(font_f);
        this.amount_drug.setBorder(BorderFactory.createTitledBorder("Số lượng cần cấp phát (số sản phẩm)"));
        formDrugLeft.add(this.amount_drug);

        this.dataDrugSelected = new ArrayList<String[]>();

        JPanel jpAddDrug = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton listDrug = new JButton("Danh sách đã chọn");
        listDrug.setBackground(Color.darkGray);
        listDrug.setForeground(Color.WHITE);
        listDrug.setBorderPainted(false);
        jpAddDrug.add(listDrug);
        listDrug.addActionListener(this.actionListener);

        JButton addDrug = new JButton("Thêm thuốc");
        addDrug.setBackground(Color.darkGray);
        addDrug.setForeground(Color.WHITE);
        addDrug.setBorderPainted(false);
        jpAddDrug.add(addDrug);
        addDrug.addActionListener(this.actionListener);

        formDrugLeft.add(jpAddDrug);

        formDrug.add(formDrugLeft);
        formDrug.add(this.dateDispensing(font_f));

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton delInfo = new JButton("Xóa dữ liệu đã nhập");
        delInfo.setFont(font_f);
        delInfo.setBackground(Color.RED);
        delInfo.setForeground(Color.WHITE);
        delInfo.setBorderPainted(false);
        delInfo.addActionListener(this.actionListener);
        footer.add(delInfo);

        JButton submit = new JButton("Hoàn tất");
        submit.setFont(font_f);
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setBorderPainted(false);
        submit.addActionListener(this.actionListener);
        footer.add(submit);

        JPanel formNorth = new JPanel();
        formNorth.setLayout(new BoxLayout(formNorth,BoxLayout.Y_AXIS));
        formNorth.add(formAddInfo);
        formNorth.add(formDrug);

        this.contentNew.setLayout(new BorderLayout());
        this.contentNew.add(formNorth,BorderLayout.NORTH);
        this.contentNew.add(footer,BorderLayout.SOUTH);
    }
    public JPanel dateDispensing(Font font_f){
        Vector<Integer> yearNum = new Vector<>();
        Calendar calendar = Calendar.getInstance();
        for(int i =  calendar.get(Calendar.YEAR); i >= 1950; i--) {
            yearNum.add(i);
        }

        this.year = new JComboBox<>(yearNum);
        this.year.setFont(font_f);
        Vector<Integer> monthNum = new Vector<>();
        for(int i = 1; i<=12; i++){
            monthNum.add(i);
        }
        this.month = new JComboBox<>(monthNum);
        this.month.setFont(font_f);

        this.day = new JTextField(3);
        this.day.setFont(font_f);


        JPanel dateDispensing = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dateDispensing.setBorder(BorderFactory.createTitledBorder("Ngày cấp thuốc"));
        dateDispensing.add(this.day);
        dateDispensing.add(this.month);
        dateDispensing.add(this.year);

        return dateDispensing;
    }
    public boolean setData(){
        int i = this.drug.getSelectedIndex();
        if(!this.amount_drug.getText().isBlank()){
            if(Integer.parseInt(this.amount_drug.getText())>0
                    &&Integer.parseInt(this.amount_drug.getText())<=this.arrDrug.get(i).getRemainingMount()
            )
            {
                for(String[] dt : this.dataDrugSelected){
                    if(dt[0].equals(this.arrDrug.get(i).getName_drug())){
                        int mountDrug = Integer.parseInt(this.amount_drug.getText()) + Integer.parseInt(dt[dt.length-1]);
                        dt[dt.length-1]= mountDrug+"";
                        int amount_drug = this.arrDrug.get(i).getRemainingMount() - Integer.parseInt(this.amount_drug.getText());
                        this.arrDrug.get(i).setRemainingMount(amount_drug);
                        DrugDAO.getInstance().updateMountDrug(this.arrDrug.get(i));
                        return true;
                    }
                }
                String[] data = {this.arrDrug.get(i).getName_drug(),this.amount_drug.getText()};
                this.dataDrugSelected.add(data);
                int amount_drug = this.arrDrug.get(i).getRemainingMount() - Integer.parseInt(this.amount_drug.getText());
                this.arrDrug.get(i).setRemainingMount(amount_drug);
                DrugDAO.getInstance().updateMountDrug(this.arrDrug.get(i));
                return true;
            }
        }
        return false;
    }

    public void setAmount_drug(String str) {
        this.amount_drug.setText(str);
    }

    public ArrayList<String[]> getDataDrugSelected() {
        return dataDrugSelected;
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

    public String getJfAddress() {
        return this.jfAddress.getText().trim();
    }

    public String getJfPhone() {
        return this.jfPhone.getText().trim();
    }

    public String getJfCCCD() {
        return this.jfCCCD.getText().trim();
    }

    public String getJfName() {
        return this.jfName.getText().trim();
    }

    public JComboBox<Object> getSexSelection() {
        return sexSelection;
    }

    public JTextField getDay() {
        return day;
    }

    public JComboBox<Integer> getYear() {
        return year;
    }

    public JComboBox<Integer> getMonth() {
        return month;
    }

    public ArrayList<Drug> getArrDrug() {
        return arrDrug;
    }
}
