package actionListener.manageDisspensing;

import view.componentsView.manageDispensing.ContentNew;
import view.componentsView.manageDispensing.ListDrugSelected;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContentNewAL implements ActionListener {
    private ContentNew contentNew;
    public ContentNewAL(ContentNew contentNew){
        this.contentNew = contentNew;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Thêm thuốc")){
            System.out.println(this.contentNew.getDrug().getSelectedIndex());
            System.out.println(this.contentNew.getAmount_drug().getText());
        } else if (src.equals("Danh sách đã chọn")) {
            new ListDrugSelected(this.contentNew.getCols(),this.contentNew.getRows());
        }
    }
}
