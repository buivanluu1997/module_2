package quan_ly_tien_dien.repository;

import quan_ly_tien_dien.model.Bill;

import java.util.List;

public interface IBillRepository {
    void addBill(Bill bill);

    Bill getByBillId(String customerCode);

    void writeFileBill(List<Bill> bill);

    void updateBill(Bill editBill);

    List<Bill> getAllBill();
}
