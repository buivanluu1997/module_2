package quan_ly_khach_hang.controller;

import quan_ly_khach_hang.model.Customer;
import quan_ly_khach_hang.repository.ICustomerRipository;
import quan_ly_khach_hang.service.CustomerService;
import quan_ly_khach_hang.service.ICustomerService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private ICustomerService customerService = new CustomerService();
    private Scanner scanner = new Scanner(System.in);

    public void showCustomerMenu() {
        while (true) {
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Hiển thị danh sách khách hàng \n" +
                    "2. Thêm khách hàng \n" +
                    "3. Xoá khách hàng theo id \n" +
                    "4. Tìm tên khách hàng \n" +
                    "5. Tìm id khách hàng \n" +
                    "6. Sắp xếp theo tên \n" +
                    "7. Sửa thông tin khách hàng \n" +
                    "8. Sắp xếp id từ cao đến thấp \n" +
                    "9. Thoát");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("<---------------------------------Hiển thị danh sách khách hàng--------------------------------->");
                    displayListCustomer();
                    break;
                case 2:
                    System.out.println("<---------------------------------Thêm khách hàng--------------------------------->");
                    addCustomer();
                    break;
                case 3:
                    System.out.println("<---------------------------------Xoá khách hàng theo id--------------------------------->");
                    deleteID();
                    break;
                case 4:
                    System.out.println("<---------------------------------Tìm tên khách hàng--------------------------------->");
                    searchNameCustomer();
                    break;
                case 5:
                    System.out.println("<---------------------------------Tìm id khách hàng--------------------------------->");
                    searchId();
                    break;
                case 6:
                    System.out.println("<---------------------------------Sắp xếp theo tên--------------------------------->");
                    sortName();
                    break;
                case 7:
                    System.out.println("<---------------------------------Sửa thông tin khách hàng--------------------------------->");
                    editCustomer();
                case 8:
                    System.out.println("<---------------------------------Sắp xếp id từ cao đến thấp--------------------------------->");
                    sortId();
                    break;
                case 9:
                    System.exit(0);
            }
        }
    }

    public void editCustomer() {
        System.out.println("Nhập id khách hàng cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên cần sửa: ");
        String name = scanner.nextLine();
        System.out.println("Nhập địa chỉ cần sửa: ");
        String address = scanner.nextLine();
        System.out.println("Nhập số điện thoại cần sửa: ");
        String phone = scanner.nextLine();
        Customer editCustomer = new Customer(id, name, address, phone);

        if (customerService.edit(editCustomer)) {
            System.out.println("Đã cập nhật khách hàng thành công");
        } else {
            System.out.println("Không tìm thấy khách hàng");
        }
    }

    public void sortId() {
        List<Customer> customers = customerService.sortId();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }


    private void sortName() {
        List<Customer> customers = customerService.sortName();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private void searchId() {
        System.out.println("Nhập id bạn muốn tìm kiếm");
        int id = Integer.parseInt(scanner.nextLine());
        Customer customer = customerService.findByID(id);
        System.out.println(customer);
    }

    public void searchNameCustomer() {
        System.out.println("Nhập tên bạn muốn tìm: ");
        String name = scanner.nextLine();
        List<Customer> customers = customerService.searchName(name);
        if (customers.size() == 0) {
            System.out.println("Không tìm thấy khách hàng");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    public void displayListCustomer() {
        for (Customer customer : customerService.getAll()) {
            System.out.println(customer);
        }
    }

    public void addCustomer() {
        System.out.println("Nhập id khách hàng: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.println("Nhập địa chỉ khách hàng: ");
        String address = scanner.nextLine();
        System.out.println("Nhập số điện thoại khách hàng: ");
        String phone = scanner.nextLine();
        Customer customer = new Customer(id, name, address, phone);
        customerService.add(customer);
    }

    public void deleteID() {
        System.out.println("Nhập id bạn muốn xoá: ");
        int id = Integer.parseInt(scanner.nextLine());
        Customer customer = customerService.findByID(id);
        if (customer == null) {
            System.out.println("Khách hàng không tìm thấy");
        } else {
            System.out.println("Bạn thật sự muốn xoá hay không? \n" +
                    "1. Yes \n" +
                    "2. No");
            int choose = Integer.parseInt(scanner.nextLine());
            if (choose == 1) {
                customerService.delete(customer);
            } else {
                System.out.println("Đã đóng.");
            }
        }
    }
}
