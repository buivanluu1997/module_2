package demo_quan_ly_khach_hang.controller;

import demo_quan_ly_khach_hang.model.Customer;
import demo_quan_ly_khach_hang.service.CustomerService;
import demo_quan_ly_khach_hang.service.ICustomerService;

import java.util.Scanner;

public class CustomerController {
    private ICustomerService customerService = new CustomerService();
    private Scanner scanner = new Scanner(System.in);

    public void showListMenu() {
        while (true) {
            System.out.println("Chon chuc nang: \n" +
                    "1. hien thi \n" +
                    "2. them \n" +
                    "3. xoa \n" +
                    "4. tim kiem ten \n" +
                    "5. sap xep theo id \n" +
                    "6. thoat");

            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    System.out.println("--------------------------------hien thi-------------------------------");
                    customerService.display();
                    break;
                case 2:
                    System.out.println("--------------------------------them-------------------------------");
                    customerService.add(inputCustomer());
                    break;
                case 3:
                    System.out.println("--------------------------------xoa-------------------------------");
                    customerService.delete(inputID());
                    break;
                case 4:
                    System.out.println("--------------------------------tim kiem ten-------------------------------");
                    customerService.search(inputName());
                    break;
                case 5:
                    System.out.println("--------------------------------sap xep theo id-------------------------------");
                    sortIdCustomer();
                case 6:
                    System.exit(0);
            }
        }
    }

    public void sortIdCustomer() {
        for (Customer customer : customerService.sortID()) {
            System.out.println(customer);
        }
    }

    public Customer inputCustomer() {
        System.out.println("Nhap id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.println("Nhap dia chi: ");
        String address = scanner.nextLine();
        System.out.println("nhap sdt: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(id, name, address, phone);
        return customer;
    }

    public int inputID() {
        System.out.println("Nhap id can xoa: ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public String inputName() {
        System.out.println("Nhap ten can tim: ");
        String name = scanner.nextLine();
        return name;
    }
}
