package demo_quan_ly_khach_hang.view;

import demo_quan_ly_khach_hang.controller.CustomerController;

public class CustomerView {
    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        customerController.showListMenu();
    }
}
