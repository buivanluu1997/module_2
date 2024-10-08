package quan_ly_tien_dien.service;

import quan_ly_tien_dien.model.Bill;

import java.util.List;

public interface IBillService {
    void addBill(Bill bill);

    Bill getByBillId(String billId);

    void updateBill(Bill editBill);

    List<Bill> getAllBill();
}
