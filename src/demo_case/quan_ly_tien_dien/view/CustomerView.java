package demo_case.quan_ly_tien_dien.view;

import demo_case.quan_ly_tien_dien.controller.CustomerForeignController;
import demo_case.quan_ly_tien_dien.controller.CustomerVietNamController;
import demo_case.quan_ly_tien_dien.model.CustomerForeign;
import demo_case.quan_ly_tien_dien.model.CustomerType;
import demo_case.quan_ly_tien_dien.model.CustomerVietNam;
import demo_case.quan_ly_tien_dien.repository.CustomerTypeRepository;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private CustomerForeignController customerForeignController = new CustomerForeignController();
    private CustomerVietNamController customerVietNamController = new CustomerVietNamController();
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÍ TIỀN ĐIỆN: \n" +
                    "Chọn chức năng: \n" +
                    "1. Thêm mới khách hàng \n" +
                    "2. Hiển thị thông tin khách hàng \n" +
                    "3. Tìm kiếm tên khách hàng \n" +
                    "4. Thoát");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("---------------------------Thêm mới khách hàng---------------------------");
                    addCustomer();
                    break;
                case 2:
                    System.out.println("---------------------------Hiển thị khách hàng---------------------------");
                    showCustomer();
                    break;
                case 3:
                    System.out.println("---------------------------Tìm tên khách hàng---------------------------");
                    searchName();
                    break;
                case 4:
                    System.exit(0);
            }
        }

    }

    private void searchName() {
        System.out.println("Nhập tên khách hàng cần tìm: ");
        String name = scanner.nextLine();
        List<CustomerVietNam> customerVietNamList = customerVietNamController.searchCustomerName(name);
        List<CustomerForeign> customerForeignList = customerForeignController.searchCustomerName(name);

        if (customerVietNamList.isEmpty() && customerForeignList.isEmpty()) {
            System.out.println("Tên khách hàng không tồn tại");
        } else {
            if (!customerVietNamList.isEmpty()) {
                for (CustomerVietNam customerVietNam : customerVietNamList) {
                    System.out.println(customerVietNam.displayInfo());
                }
            }
            if (!customerForeignList.isEmpty()) {
                for (CustomerForeign customerForeign : customerForeignList) {
                    System.out.println(customerForeign.displayInfo());
                }
            }
        }
    }

    private void showCustomer() {
        System.out.println("--------------Khách hàng Việt Nam--------------");
        List<CustomerVietNam> vietNamList = customerVietNamController.getAllCustomer();
        for (CustomerVietNam customerVietNam : vietNamList) {
            System.out.println(customerVietNam.displayInfo());
        }
        System.out.println("--------------Khách hàng nước ngoài--------------");
        List<CustomerForeign> foreignList = customerForeignController.getAllCustomer();
        for (CustomerForeign customerForeign : foreignList) {
            System.out.println(customerForeign.displayInfo());
        }
    }

    private void addCustomer() {
        System.out.println("Chọn thêm mới khách hàng: \n" +
                "1. Thêm mới khách hàng Việt Nam \n" +
                "2. Thêm mới khách hàng nước ngoài");
        int chooseAdd = Integer.parseInt(scanner.nextLine());

        switch (chooseAdd) {
            case 1:
                addCustomerVietNam();
                System.out.println("Đã thêm khách hàng Việt Nam thành công");
                break;
            case 2:
                addCustomerForeign();
                System.out.println("Đã thêm khách hàng nước ngoài thành công");
                break;
            default:
                System.out.println("Bạn chọn ngoài 1 hoặc 2 nên thoát");
                break;
        }
    }

    private void addCustomerForeign() {
        System.out.println("Nhập mã khách hàng (KHNN-XXXXX (X : 0÷9)): ");
        String customerCode = newCodeCustomerForeign();
        CustomerForeign customerForeign = customerForeignController.searchIdCustomer(customerCode);
        if (customerForeign == null) {
            System.out.println("Nhập tên khách hàng: ");
            String name = scanner.nextLine();
            System.out.println("Nhập quốc tịch khách hàng: ");
            String nationality = scanner.nextLine();

            CustomerForeign newCustomerForeign = new CustomerForeign(customerCode, name, nationality);
            customerForeignController.addCustomer(newCustomerForeign);
        } else {
            System.out.println("Khách hàng đã tồn tại");
        }

    }

    public String newCodeCustomerForeign() {
        while (true) {
            String code = scanner.nextLine();
            if (code.matches("^KHNN-\\d{5}$")) {
                return code;
            } else {
                System.out.println("Bạn nhập lại, phải nhập mã khách hàng phải đúng như quy đinh");
            }
        }
    }


    private void addCustomerVietNam() {
        System.out.println("Nhập mã khách hàng (KHVN-XXXXX (X : 0÷9)): ");
        String codeCustomer = newCodeCustomerVietNam();
        CustomerVietNam customerVietNam = customerVietNamController.searchIdCustomer(codeCustomer);
        if (customerVietNam == null) {
            System.out.println("Nhập họ và tên khách hàng: ");
            String name = scanner.nextLine();
            CustomerType customerType = getCustomerType();
            System.out.println("Nhập định mức tiêu thụ");
            double norm = Double.parseDouble(scanner.nextLine());
            CustomerVietNam newCustomerVietNam = new CustomerVietNam(codeCustomer, name, customerType, norm);
            customerVietNamController.addCustomer(newCustomerVietNam);
        } else {
            System.out.println("Khách hàng đã tồn tại");
        }

    }

    private CustomerType getCustomerType() {
        System.out.println("Chọn loại khách hàng: ");
        List<CustomerType> customerTypeList = CustomerTypeRepository.getAllCustomerType();
        for (int i = 0; i < customerTypeList.size(); i++) {
            System.out.println((i + 1) + ". " + customerTypeList.get(i));
        }
        int chooseType = Integer.parseInt(scanner.nextLine());
        CustomerType customerType = null;
        switch (chooseType) {
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
                System.out.println("Bạn phải chọn 1-3, chọn ngoài nên thoát");
                break;
        }
        return customerType;
    }

    public String newCodeCustomerVietNam() {
        while (true) {
            String inputCode = scanner.nextLine();
            if (inputCode.matches("^KHVN-\\d{5}$")) {
                return inputCode;
            } else {
                System.out.println("Bạn nhập lại, phải nhập mã khách hàng phải đúng như quy đinh");
            }
        }

    }
}
