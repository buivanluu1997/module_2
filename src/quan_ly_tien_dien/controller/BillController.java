package quan_ly_tien_dien.controller;

import quan_ly_tien_dien.model.Bill;
import quan_ly_tien_dien.service.BillService;
import quan_ly_tien_dien.service.IBillService;

import java.util.List;

public class BillController {
    private IBillService billService = new BillService();
    public void addBill(Bill bill) {
        billService.addBill(bill);
    }

    public void updateBill(Bill editBill) {
        billService.updateBill(editBill);
    }
    public Bill getByBillId(String billId) {
        return billService.getByBillId(billId);
    }

    public List<Bill> getAllBill() {
        return billService.getAllBill();
    }
}
