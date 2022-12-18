package view.componentsView.manageDispensing;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ListDrugSelected extends JFrame {
    private Vector<Object> cols;
    private Vector<Vector<java.io.Serializable>> rows;
    public ListDrugSelected(Vector<Object> cols, Vector<Vector<java.io.Serializable>> rows ){
        this.cols = cols;
        this.rows = rows;
        this.init();
        this.setVisible(true);
    }

    private void init() {
        this.setTitle("Hệ thống quản lý cấp phát thuốc bệnh nhân - Danh sách thuốc chọn");
        this.setSize(600,300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        Font font_f = new Font("Cascadia",Font.BOLD,15);

        JTable tableModelDrugSelected = new JTable(this.rows,this.cols);
        tableModelDrugSelected.setFont(font_f);
        tableModelDrugSelected.setEnabled(false);
        JScrollPane tbDrugSel = new JScrollPane(tableModelDrugSelected,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tbDrugSel.setBorder(BorderFactory.createTitledBorder("Danh sách thuốc chọn"));

        this.setLayout(new BorderLayout());
        this.add(tbDrugSel,BorderLayout.CENTER);
    }

}
