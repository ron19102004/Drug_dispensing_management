package actionListener.manageDisspensing;

import dataAccessObject.PatientDAO;
import model.Patient;
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
            if(this.contentNew.setData()) System.out.println("ADD DRUG SUCCESSFULLY");
            else System.out.println("ADD DRUG UNSUCCESSFULLY");
            this.contentNew.getDrug().setSelectedIndex(0);
            this.contentNew.setAmount_drug("");
        } else if (src.equals("Danh sách đã chọn")) {
            new ListDrugSelected(this.contentNew.getDataDrugSelected(),this.contentNew.getArrDrug());
        } else if (src.equals("Hoàn tất")){
            String sex = (String) this.contentNew.getSexSelection().getSelectedItem();
            Patient patient = new Patient(this.contentNew.getJfName(),
                                          this.contentNew.getJfCCCD(),
                                          this.contentNew.getJfPhone(),
                                          this.contentNew.getJfAddress(),
                                          sex);
            int check = PatientDAO.getInstance().create(patient);
            if(check!=0) System.out.println("CREATE PATIENT /POST -200");
            else System.out.println("CREATE PATIENT /POST -404");

            String date = null;
            if(Integer.parseInt(this.contentNew.getDay().getText())<=31
                    &&Integer.parseInt(this.contentNew.getDay().getText())>0)
            {
                date = this.contentNew.getYear().getSelectedItem()+"/"+this.contentNew.getMonth().getSelectedItem()+"/"+this.contentNew.getDay().getText();
            }
        }
    }
}
