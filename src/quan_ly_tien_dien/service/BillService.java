package quan_ly_tien_dien.service;

import quan_ly_tien_dien.model.Bill;
import quan_ly_tien_dien.repository.BillRepository;
import quan_ly_tien_dien.repository.IBillRepository;

import java.util.List;

public class BillService implements IBillService {
    private IBillRepository billRepository = new BillRepository();
    @Override
    public void addBill(Bill bill) {
        billRepository.addBill(bill);
    }

    @Override
    public Bill getByBillId(String billId) {
        return billRepository.getByBillId(billId);
    }

    @Override
    public void updateBill(Bill editBill) {
        billRepository.updateBill(editBill);
    }


    @Override
    public List<Bill> getAllBill() {
        return billRepository.getAllBill();
    }
}
