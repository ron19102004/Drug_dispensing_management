package view.componentsView.manageDispensing;

import model.AllocationDetails;
import model.Drug;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class ListDrugSelected extends JFrame {
    private DefaultTableModel cols;
    private ArrayList<String[]> data;
    private JTable tableModelDrugSelected;
    private ArrayList<Drug> drugArrayList;
    public ListDrugSelected(ArrayList<String[]> data , ArrayList<Drug> drugArrayList){
        this.data = data;
        this.drugArrayList = drugArrayList;
        this.init();
        this.setVisible(true);
    }

    private void init() {
        this.setTitle("Hệ thống quản lý cấp phát thuốc bệnh nhân - Danh sách thuốc chọn");
        this.setSize(600,300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        Font font_f = new Font("Cascadia",Font.BOLD,15);

        this.setCols();
        this.tableModelDrugSelected = new JTable(this.cols);
        this.putData();
        this.tableModelDrugSelected.setFont(font_f);
        this.tableModelDrugSelected.setEnabled(false);
        JTableHeader jTableHeader = this.tableModelDrugSelected.getTableHeader();
        jTableHeader.setFont(font_f);
        jTableHeader.setBackground(Color.DARK_GRAY);
        jTableHeader.setForeground(Color.LIGHT_GRAY);
        jTableHeader.setOpaque(false);
        JScrollPane tbDrugSel = new JScrollPane(this.tableModelDrugSelected,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tbDrugSel.setBorder(BorderFactory.createTitledBorder("Danh sách thuốc chọn"));

        this.setLayout(new BorderLayout());
        this.add(tbDrugSel,BorderLayout.CENTER);
    }
    private void setCols(){
        this.cols = new DefaultTableModel();
        this.cols.addColumn("Tên thuốc");
        this.cols.addColumn("Số lượng");
    }
    private void putData(){
        for(String[] data : this.data){
            this.cols.addRow(data);
        }
    }
}
