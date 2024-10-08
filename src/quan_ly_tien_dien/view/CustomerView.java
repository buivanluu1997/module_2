package quan_ly_tien_dien.view;

import quan_ly_tien_dien.controller.BillController;
import quan_ly_tien_dien.controller.CustomerForeignController;
import quan_ly_tien_dien.controller.CustomerVietNamController;
import quan_ly_tien_dien.model.Bill;
import quan_ly_tien_dien.model.CustomerForeign;
import quan_ly_tien_dien.model.CustomerVietNam;
import quan_ly_tien_dien.model.CustomerType;
import quan_ly_tien_dien.repository.CustomerTypeRepository;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private CustomerForeignController customerForeignController = new CustomerForeignController();
    private CustomerVietNamController customerVietNamController = new CustomerVietNamController();
    private Scanner scanner = new Scanner(System.in);
    private BillController billController = new BillController();

    public void showMenu() {
        while (true) {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÍ HOÁ ĐƠN TIỀN ĐIỆN \n" +
                    "Chọn chức năng: \n" +
                    "1. Thêm mới khách hàng \n" +
                    "2. Hiển thị thông tin khách hàng \n" +
                    "3. Tìm kiếm tên khách hàng \n" +
                    "4. Thêm mới hoá đơn \n" +
                    "5. Chỉnh sửa hoá đơn \n" +
                    "6. Hiển thị thông tin chi tiết hoá đơn \n" +
                    "7. Thoát");
            try {
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("<--------------------------Thêm mới khách hàng-------------------------->");
                        newAddCustomer();
                        break;
                    case 2:
                        System.out.println("<--------------------------Hiển thị thông tin khách hàng-------------------------->");
                        displayCustomer();
                        break;
                    case 3:
                        System.out.println("<--------------------------Tìm kiếm tên khách hàng-------------------------->");
                        searchName();
                        break;
                    case 4:
                        System.out.println("<--------------------------Thêm mới hoá đơn------------------------->");
                        addBill();
                        break;
                    case 5:
                        System.out.println("<--------------------------Chỉnh sửa hoá đơn------------------------->");
                        showBill();
                        System.out.println("Nhập vào id của hoá đơn: ");
                        String inputBillId = scanner.nextLine();
                        Bill bill = billController.getByBillId(inputBillId);
                        if (bill == null) {
                            System.out.println("Hoá đơn không tồn tại");
                            break;
                        }

                        System.out.println("Nhập mã khách hàng cần thay đổi");
                        String inputCustomerId = scanner.nextLine();
                        CustomerVietNam customerVietNam = customerVietNamController.searchCustomerId(inputCustomerId);
                        if (customerVietNam != null) {
                            bill.setCustomer(customerVietNam);
                        }

                        CustomerForeign customerForeign = customerForeignController.SearchCustomerId(inputCustomerId);
                        if (customerForeign != null) {
                            bill.setCustomer(customerForeign);
                        }

                        billController.updateBill(bill);
                        break;

                    case 6:
                        System.out.println("<--------------------------Hiển thị thông tin chi tiết hoá đơn------------------------->");
                        showBill();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Bạn chọn không đúng số nguyên");
            }
        }
    }

    private void showBill() {
        List<Bill> billList = billController.getAllBill();
        for (Bill bill : billList) {
            System.out.println(bill);
        }
    }

    private void addBill() {
        System.out.println("Danh sách khách hàng: ");
        displayCustomer();
        System.out.println("Chọn khách hàng cần thêm vào hoá đơn: \n" +
                "1. Khách hàng Việt Nam \n" +
                "2. Khách hàng nước ngoài.");
        int choose2 = Integer.parseInt(scanner.nextLine());
        switch (choose2) {
            case 1:
                addBillCustomerVietNam();
                break;
            case 2:
                addBillCustomerForeign();
                break;
            default:
                System.out.println("Chọn ngoài 1-2 nên thoát");
                break;
        }
    }

    private void addBillCustomerForeign() {
        System.out.println("Nhập mã khách hàng nước ngoài(KHNN-XXXXX (X : 0÷9)): ");
        String inputCodeForeign = codeCustomerForeign();
        Bill bill1 = billController.getByBillId(inputCodeForeign);
        if (bill1 == null) {
            System.out.println("Nhập ngày ra hoá đơn(xx/yy/zzzz)");
            String date = dateBill();
            System.out.println("Nhập số lượng tiêu thụ: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập đơn giá: ");
            double price = Double.parseDouble(scanner.nextLine());

            CustomerForeign customerForeign = customerForeignController.SearchCustomerId(inputCodeForeign);

            Bill newBill = new Bill(customerForeign, date, quantity, price);
            billController.addBill(newBill);
        } else {
            System.out.println("Khách hàng đã tồn tại");
        }
    }

    private void addBillCustomerVietNam() {
        System.out.println("Nhập mã khách hàng Việt Nam(KHVN-XXXXX (X : 0÷9)): ");
        String inputCodeVietNam = codeCustomerVietNam();
        Bill bill = billController.getByBillId(inputCodeVietNam);
        if (bill == null) {
            System.out.println("Nhập ngày ra hoá đơn(xx/yy/zzzz)");
            String date = dateBill();
            System.out.println("Nhập số lượng tiêu thụ: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập đơn giá: ");
            double price = Double.parseDouble(scanner.nextLine());

            CustomerVietNam customerVietNam = customerVietNamController.searchCustomerId(inputCodeVietNam);

            Bill newBill = new Bill(customerVietNam, date, quantity, price);
            billController.addBill(newBill);
        } else {
            System.out.println("Khách hàng đã tồn tại");
        }
    }

    private String dateBill() {
        while (true) {
            String invoiceDate = scanner.nextLine();
            if (invoiceDate.matches("^([0-2][0-9]|(3)[0-1])/(0[1-9]|1[0-2])/(\\d{4})$")) {
                return invoiceDate;
            } else {
                System.out.println("Nhập không đúng quy định của ngày tháng năm, bạn hãy nhập lại");
            }
        }
    }


    private void searchName() {
        System.out.println("Nhập tên cần tìm: ");
        String name = scanner.nextLine();
        List<CustomerVietNam> vietNamList = customerVietNamController.searchNameCustomer(name);
        List<CustomerForeign> foreignList = customerForeignController.searchNameCustomer(name);

        if (vietNamList.isEmpty() && foreignList.isEmpty()) {
            System.out.println("Không có khách hàng nào được tìm thấy");
        } else {
            if (!vietNamList.isEmpty()) {
                for (CustomerVietNam customerVietNam : vietNamList) {
                    System.out.println(customerVietNam.displayInfo());
                }
            }
            if (!foreignList.isEmpty()) {
                for (CustomerForeign customerForeign : foreignList) {
                    System.out.println(customerForeign.displayInfo());
                }
            }
        }
    }

    private void displayCustomer() {
        List<CustomerVietNam> vietNamList = customerVietNamController.getAllCustomer();
        for (CustomerVietNam customerVietNam : vietNamList) {
            System.out.println(customerVietNam.displayInfo());
        }
        List<CustomerForeign> foreignList = customerForeignController.getAllCustomer();
        for (CustomerForeign customerForeign : foreignList) {
            System.out.println(customerForeign.displayInfo());
        }
    }

    private void newAddCustomer() {
        System.out.println("Chọn thêm khách hàng: \n" +
                "1. Thêm khách hàng Việt Nam \n" +
                "2. Thêm khách hàng nước ngoài");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                addCustomerVietNam();
                break;
            case 2:
                addCustomerForeign();
                break;
            default:
                System.out.println("Chọn ngoài 1 và 2 nên thoát");
                break;
        }
    }

    private void addCustomerForeign() {
        System.out.println("Nhập mã khách hàng nước ngoài(KHNN-XXXXX (X : 0÷9)): ");
        String inputCode = codeCustomerForeign();
        CustomerForeign customerForeign = customerForeignController.SearchCustomerId(inputCode);
        if (customerForeign == null) {
            System.out.println("Nhập họ và tên: ");
            String name = scanner.nextLine();
            System.out.println("Nhập quốc tịch");
            String nationality = scanner.nextLine();

            CustomerForeign foreign = new CustomerForeign(inputCode, name, nationality);

            customerForeignController.addCustomer(foreign);
        } else {
            System.out.println("Khách hàng đã tồn tại.");
        }
    }

    private void addCustomerVietNam() {
        System.out.println("Nhập mã khách hàng Việt Nam(KHVN-XXXXX (X : 0÷9)): ");
        String inputCode = codeCustomerVietNam();

        CustomerVietNam customerVietNam = customerVietNamController.searchCustomerId(inputCode);
        if (customerVietNam == null) {
            System.out.println("Nhập họ và tên: ");
            String name = scanner.nextLine();

            CustomerType customerType = getCustomerType();

            System.out.println("Nhập định mức tiêu thụ: ");
            double norm = Double.parseDouble(scanner.nextLine());

            CustomerVietNam newCustomerVietNam = new CustomerVietNam(inputCode, name, customerType, norm);

            customerVietNamController.addCustomer(newCustomerVietNam);
        } else {
            System.out.println("Khách hàng đã tồn tại.");
        }
    }

    private CustomerType getCustomerType() {
        System.out.println("Chọn loại khách hàng: ");
        List<CustomerType> customerTypeList = CustomerTypeRepository.customerTypeList();
        for (int i = 0; i < customerTypeList.size(); i++) {
            System.out.println((i + 1) + ". " + customerTypeList.get(i));
        }
        int chon2 = Integer.parseInt(scanner.nextLine());
        CustomerType customerType = null;
        switch (chon2) {
            case 1:
                customerType = customerTypeList.get(0);
                break;
            case 2:
                customerType = customerTypeList.get(1);
                break;
            case 3:
                customerType = customerTypeList.get(2);
                break;
            default:
                System.out.println("Bạn chọn ngoài 1-3 nên thoát.");
                break;
        }
        return customerType;
    }

    private String codeCustomerVietNam() {
        while (true) {
            String inputCustomerCode = scanner.nextLine();
            if (inputCustomerCode.matches("^KHVN-\\d{5}$")) {
                return inputCustomerCode;
            } else {
                System.out.println("Nhập sai quy định, hãy nhập lại.");
            }
        }
    }

    private String codeCustomerForeign() {
        while (true) {
            String inputCustomerCode = scanner.nextLine();
            if (inputCustomerCode.matches("^KHNN-\\d{5}$")) {
                return inputCustomerCode;
            } else {
                System.out.println("Nhập sai quy định, hãy nhập lại.");
            }
        }
    }
}
