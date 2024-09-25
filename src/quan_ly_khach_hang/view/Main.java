package quan_ly_khach_hang.view;

import quan_ly_khach_hang.controller.CustomerController;

public class Main {
    public static void main(String[] args) {
       CustomerController customerController = new CustomerController();
       customerController.showCustomerMenu();
    }
}
