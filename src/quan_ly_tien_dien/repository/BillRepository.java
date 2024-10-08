    package quan_ly_tien_dien.repository;

    import quan_ly_tien_dien.model.Bill;
    import quan_ly_tien_dien.model.Customer;
    import quan_ly_tien_dien.model.CustomerForeign;
    import quan_ly_tien_dien.model.CustomerVietNam;
    import quan_ly_tien_dien.util.ReadWriteFile;

    import java.util.ArrayList;
    import java.util.List;

    public class BillRepository implements IBillRepository {
        private final String FILE_BILL = "src/quan_ly_tien_dien/data/bill.csv";
        CustomerForeignRepository customerForeignRepository = new CustomerForeignRepository();
        CustomerVietNamRepository customerVietNamRepository = new CustomerVietNamRepository();

        @Override
        public void addBill(Bill bill) {
            List<Bill> billList = getAllBill();
            billList.add(bill);

            writeFileBill(billList);
        }

        @Override
        public Bill getByBillId(String billId) {
           List<Bill> billList = getAllBill();
           for (Bill bill : billList) {
               System.out.println(bill.toString());

               if (bill.getBillId().equals(billId)) {
                   return bill;
               }
           }
           return null;
        }

        @Override
        public void writeFileBill(List<Bill> billList) {
            List<String> stringList = new ArrayList<>();
            for (Bill bill : billList) {
                String line = bill.convertBillToLine();
                stringList.add(line);
            }
            ReadWriteFile.writeFile(FILE_BILL, stringList, false);
        }

        @Override
        public void updateBill(Bill editBill) {
            List<Bill> billList = getAllBill();
            System.out.println(editBill.getBillId());

            for (int i = 0; i < billList.size(); i++) {
                Bill bill = billList.get(i);
                System.out.println(bill.getBillId());
                if (bill.getBillId().equals(editBill.getBillId())) {
                    billList.set(i, editBill);
                    break;
                }
            }
            writeFileBill(billList);
        }


        @Override
        public List<Bill> getAllBill() {

           List<String> stringList = ReadWriteFile.readFile(FILE_BILL);
           List<Bill> billList = new ArrayList<>();
           for (String line : stringList) {
               String[] array = line.split(",");
               String billId = array[0];
               String customerCode = array[1];
               String invoiceDate = array[2];
               int quantity = Integer.parseInt(array[3]);
               double price = Double.parseDouble(array[4]);
               double intoMoney = Double.parseDouble(array[5]);
               CustomerVietNam customerVietNam = customerVietNamRepository.searchCustomerId(customerCode);
               if (customerVietNam != null) {
                   Bill bill = new Bill(billId, customerVietNam, invoiceDate, quantity, price, intoMoney);
                   billList.add(bill);
                   continue;
               }
               CustomerForeign customerForeign = customerForeignRepository.searchCustomerId(customerCode);
               if (customerForeign != null) {
                   Bill bill = new Bill(billId, customerForeign, invoiceDate, quantity, price, intoMoney);
                   billList.add(bill);
               }
           }
           return billList;
        }
    }
