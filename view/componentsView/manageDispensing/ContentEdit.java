package view.componentsView.manageDispensing;

import javax.swing.*;


public class ContentEdit extends JPanel {
    private JPanel contentEdit;
    public ContentEdit(){
        this.contentEdit = new JPanel();
        this.init();
    }
    public void init(){
        this.contentEdit.setBorder(BorderFactory.createTitledBorder("Chỉnh sửa thông tin bệnh nhân"));
    }
    public JPanel getContentEdit() {
        return contentEdit;
    }
}
