package quan_ly_phuong_tien.view;


import quan_ly_phuong_tien.controller.VehicleController;
import quan_ly_phuong_tien.repository.VehicleRipository;

public class Main {
    public static void main(String[] args) {
        VehicleController vehicleController = new VehicleController();
        vehicleController.showCustomerMenu();
    }
}
