package test_quan_ly_tien_dien.view;

import test_quan_ly_tien_dien.controller.CustomerForeignController;
import test_quan_ly_tien_dien.controller.CustomerVietNamController;
import test_quan_ly_tien_dien.model.CustomerForeign;
import test_quan_ly_tien_dien.model.CustomerType;
import test_quan_ly_tien_dien.model.CustomerVietNam;
import test_quan_ly_tien_dien.repository.CustomerTypeRepository;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private CustomerVietNamController customerVietNamController = new CustomerVietNamController();
    private CustomerForeignController customerForeignController = new CustomerForeignController();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÍ HOÁ ĐƠN TIỀN ĐIỆN \n" +
                    "Chọn chức năng: \n" +
                    "1. Thêm mới khách hàng \n" +
                    "2. Hiển thị khách hàng \n" +
                    "3. Tìm khách hàng theo id \n" +
                    "4. Xoá khách hàng theo id \n" +
                    "5. Tìm khách hàng theo tên");
            try {
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("----------------------Thêm mới khách hàng----------------------");
                        addCustomer();
                        break;
                    case 2:
                        System.out.println("----------------------Hiển thị khách hàng----------------------");
                        showCustomer();
                        break;
                    case 3:
                        System.out.println("----------------------Tìm khách hàng theo id----------------------");
                        searchIdCustomer();
                        break;
                    case 4:
                        System.out.println("----------------------Xoá hàng theo id----------------------");
                        deleteCustomer();
                        break;
                    case 5:
                        System.out.println("----------------------Tìm khách hàng theo tên----------------------");
                        searchNameCustomer();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Chọn không phải là số nguyên");
            }
        }
    }

    private void searchNameCustomer() {
        System.out.println("Nhập tên khách hàng cần tìm: ");
        String name = scanner.nextLine();

        List<CustomerVietNam> customerVietNamList = customerVietNamController.findByName(name);
        List<CustomerForeign> customerForeignList = customerForeignController.findByName(name);

        if (customerVietNamList.isEmpty() && customerForeignList.isEmpty()) {
            System.out.println("Tên khách hàng không tồn tại");
        } else {
            if (!customerVietNamList.isEmpty()) {
                for (CustomerVietNam customerVietNam : customerVietNamList) {
                    System.out.println(customerVietNam);
                }
            }
            if (!customerForeignList.isEmpty()) {
                for (CustomerForeign customerForeign : customerForeignList) {
                    System.out.println(customerForeign);
                }
            }
        }
    }

    private void deleteCustomer() {
        System.out.println("Nhập mã khách hàng cần xoá: \n" +
                "Khách hàng Việt Nam (KHVN-XXXXX (X: 0-9)) \n" +
                "Khách hàng nước ngoài (KHNN-XXXXX (X: 0-9)");
        String code = scanner.nextLine();
        if (code.matches("^(KHVN|KHNN)-\\d{5}$")) {
            CustomerVietNam customerVietNam = customerVietNamController.findById(code);
            CustomerForeign customerForeign = customerForeignController.findById(code);

            if (customerVietNam == null && customerForeign == null) {
                System.out.println("Không tìm thấy khách hàng");
            } else {
                System.out.println("Bạn có muốn xoá không: \n" +
                        "1. Có \n" +
                        "2. Không");
                try {
                    int choose = Integer.parseInt(scanner.nextLine());
                    switch (choose) {
                        case 1:
                            if (customerVietNam != null) {
                                customerVietNamController.delete(code);
                            }
                            if (customerForeign != null) {
                                customerForeignController.delete(code);
                            }
                            System.out.println("Đã xoá khách hàng thành công");
                            break;
                        default:
                            System.out.println("Trở về màn hình chính");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: Chọn không phải là số nguyên");
                }
            }
        } else {
            System.out.println("Khách hàng không tồn tại");
        }
    }

    private void searchIdCustomer() {
        System.out.println("Nhập mã khách hàng cần tìm: \n" +
                "Khách hàng Việt Nam (KHVN-XXXXX (X: 0-9)) \n" +
                "Khách hàng nước ngoài (KHNN-XXXXX (X: 0-9)");
        String code = scanner.nextLine();
        if (code.matches("^(KHVN|KHNN)-\\d{5}$")) {
            CustomerVietNam customerVietNam = customerVietNamController.findById(code);
            CustomerForeign customerForeign = customerForeignController.findById(code);
            if (customerVietNam == null && customerForeign == null) {
                System.out.println("Khách hàng không tìm thấy");
            } else {
                if (customerVietNam != null) {
                    System.out.println(customerVietNam.displayInfo());
                }
                if (customerForeign != null) {
                    System.out.println(customerForeign.displayInfo());
                }
            }
        } else {
            System.out.println("Nhập mã khách hàng không đúng quy định");
        }
    }


    private void showCustomer() {
        System.out.println("---------Khách hàng Việt Nam---------");
        List<CustomerVietNam> customerVietNamList = customerVietNamController.findAll();
        for (CustomerVietNam customerVietNam : customerVietNamList) {
            System.out.println(customerVietNam.displayInfo());
        }
        System.out.println("---------Khách hàng nước ngoài---------");
        List<CustomerForeign> customerForeignList = customerForeignController.findAll();
        for (CustomerForeign customerForeign : customerForeignList) {
            System.out.println(customerForeign.displayInfo());
        }
    }

    private void addCustomer() {
        System.out.println("Chọn khách hàng thêm mới \n" +
                "1. Khách hàng Việt Nam \n" +
                "2. Khách hàng nước ngoài");
        try {
            int chooseAdd = Integer.parseInt(scanner.nextLine());
            switch (chooseAdd) {
                case 1:
                    addCustomerVietNam();
                    break;
                case 2:
                    addCustomerForeign();
                    break;
                default:
                    System.out.println("Chọn ngoài 1-2 nên thoát");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: chọn không phải là số nguyên");
        }
    }

    private void addCustomerForeign() {
        System.out.println("Nhập mã theo định dạng KHNN-XXXXX(X:0-9): ");
        String foreignId = newForeignId();

        CustomerForeign customerForeign = customerForeignController.findById(foreignId);
        if (customerForeign == null) {
            System.out.println("Nhập tên khách hàng: ");
            String name = scanner.nextLine();
            System.out.println("Nhập quốc tịch: ");
            String country = scanner.nextLine();

            CustomerForeign newCustomerForeign = new CustomerForeign(foreignId, name, country);
            customerForeignController.add(newCustomerForeign);
            System.out.println("Đã thêm khách hàng thành công");
        } else {
            System.out.println("Khách hàng đã tồn tại");
        }
    }


    private void addCustomerVietNam() {
        System.out.println("Nhập mã theo định dạng KHVN-XXXXX(X:0-9): ");
        String idCustomerVN = newIdVN();

        CustomerVietNam customerVietNam = customerVietNamController.findById(idCustomerVN);
        if (customerVietNam == null) {
            System.out.println("Nhập họ và tên khách hàng: ");
            String name = scanner.nextLine();
            System.out.println("Chọn loại khách hàng: ");
            String customerType = getCustomerType();
            System.out.println("Nhập định mức tiêu thụ: ");
            int norm = Integer.parseInt(scanner.nextLine());

            CustomerVietNam newCustomerVietNam = new CustomerVietNam(idCustomerVN, name, customerType, norm);
            customerVietNamController.add(newCustomerVietNam);
            System.out.println("Đã thêm khách hàng thành công");
        } else {
            System.out.println("Khách hàng đã tồn tại");
        }
    }

    private String getCustomerType() {
        CustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();
        List<CustomerType> customerTypeList = customerTypeRepository.getCustomerTypes();
        for (int i = 0; i < customerTypeList.size(); i++) {
            System.out.println((i + 1) + ". " + customerTypeList.get(i).csvCustomerType());
        }
        String customerType = "";
        try {
            int chooseType = Integer.parseInt(scanner.nextLine());
            switch (chooseType) {
                case 1:
                    customerType = customerTypeList.get(0).getType();
                    break;
                case 2:
                    customerType = customerTypeList.get(1).getType();
                    break;
                case 3:
                    customerType = customerTypeList.get(2).getType();
                    break;
                default:
                    System.out.println("Chọn ngoài 1-3 nên thoát");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Chọn không phải là số nguyên");
        }
        return customerType;
    }

    public String newIdVN() {
        while (true) {
            String inputCode = scanner.nextLine();
            if (inputCode.matches("^KHVN-\\d{5}$")) {
                return inputCode;
            } else {
                System.out.println("Nhập không đúng, nhập lại theo quy định");
            }
        }
    }

    public String newForeignId() {
        while (true) {
            String inputCode = scanner.nextLine();
            if (inputCode.matches("^KHNN-\\d{5}$")) {
                return inputCode;
            } else {
                System.out.println("Nhập không đúng, nhập lại theo quy định");
            }
        }
    }
}

