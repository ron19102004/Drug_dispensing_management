package view.componentsView.manageDispensing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.Serializable;
import java.util.Vector;

public class ListDrugSelected extends JFrame {
    private DefaultTableModel cols;
    private Vector<Vector<java.io.Serializable>> data;
    private JTable tableModelDrugSelected;
    public ListDrugSelected(Vector<Vector<java.io.Serializable>> data ){
        this.data = data;
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
        for(Vector<java.io.Serializable> item : data){
            this.cols.addRow(item);
        }
    }
}
