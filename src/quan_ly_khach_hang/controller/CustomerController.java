package quan_ly_khach_hang.controller;

import quan_ly_khach_hang.model.Customer;
import quan_ly_khach_hang.service.CustomerService;

import java.util.Scanner;

public class CustomerController {
    private static CustomerService customerService = new CustomerService();
    private static Scanner scanner = new Scanner(System.in);

    public static void showCustomerMenu() {
        while (true) {
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Hiển thị danh sách khách hàng \n" +
                    "2. Thêm khách hàng \n" +
                    "3. Xoá khách hàng \n" +
                    "4. Tìm tên khách hàng \n" +
                    "5. Thoát");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("<=======================Hiển thị danh sách khách hàng=======================>");
                    customerService.displayCustomer();
                    break;
                case 2:
                    System.out.println("<===========================Thêm khách hàng==========================>");
                    customerService.add(inputCustomer());
                    break;
                case 3:
                    System.out.println("<================================Xoá khách hàng===============================>");
                    customerService.delete(deleteCustomer());
                case 4:
                    System.out.println("<===============================Tìm tên khách hàng===============================>");
                    customerService.searchName(searchNameCustomer());
                case 5:
                    System.exit(0);
            }

        }
    }

    public static Customer inputCustomer() {
        System.out.println("Nhập id khách hàng:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập số điện thoai");
        String phoneNumber = scanner.nextLine();

        Customer customer = new Customer(id, name, address, phoneNumber);
        return customer;
    }

    public static int deleteCustomer() {
        System.out.println("Nhập id bạn muốn xoá");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public static String searchNameCustomer() {
        System.out.println("Nhập tên muốn tìm kiếm: ");
        String name = scanner.nextLine();
        return name;
    }
}
