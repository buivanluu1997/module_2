package quan_ly_phuong_tien.controller;

import quan_ly_phuong_tien.model.*;
import quan_ly_phuong_tien.service.IVehicleService;
import quan_ly_phuong_tien.service.VehicleService;

import java.util.Scanner;

public class VahicleController {
    private IVehicleService vahicleService = new VehicleService();
    private Scanner scanner = new Scanner(System.in);


    public void showCustomerMenu() {
        while (true) {
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Thêm mới phương tiện \n" +
                    "2. Hiển thị \n" +
                    "3. Thoát");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("<------------------------------Thêm phương tiện------------------------------->");
                    addNewVehicle();
                    break;
                case 2:
                    System.out.println("<--------------------------------Hiển thị phương tiện------------------------------->");
                    displayVehicle();
                case 3:

            }
        }
    }

    private void displayVehicle() {
        System.out.println("Chọn hiển thị phương tiện \n" +
                "1. Hiển thị xe tải \n" +
                "2. Hiển thị xe ô tô \n" +
                "3. Hiển thị xe máy");
        int index = Integer.parseInt(scanner.nextLine());
        switch (index) {
            case 1:
                for (Truck truck : vahicleService.displayListTruck()) {
                    System.out.println(truck);
                }
                break;
            case 2:
                for (Oto oto : vahicleService.displayListOto()) {
                    System.out.println(oto);
                }
                break;
            case 3:
                for (Motorcycle motorcycle : vahicleService.displayListMotorcycle()) {
                    System.out.println(motorcycle);
                }
                break;
            default:
                System.out.println("Bạn nhập số lựa chọn sai");
        }
    }


    public void addNewVehicle() {
        System.out.println("Chọn loại xe để thêm: \n" +
                "1. Xe Tải \n" +
                "2. Xe Ô tô \n" +
                "3. Xe Máy");
        int chooseVehicle = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập biển kiểm soát: ");
        String licensePlate = scanner.nextLine();
        System.out.println("Chọn hãng sản xuất: ");
        Manufacturer selectedManufacturer = getSelectedManufacturer();
        System.out.println("Nhập năm sản xuất: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();

        switch (chooseVehicle) {
            case 1:
                System.out.println("Nhập tải trọng: ");
                double loadCapacity = Double.parseDouble(scanner.nextLine());
                Truck truck = new Truck(licensePlate, selectedManufacturer, year, owner, loadCapacity);
                vahicleService.addVehicle(truck);
                break;
            case 2:
                System.out.println("Nhập số chỗ ngồi: ");
                int seatNumber = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập kiểu xe ( dịch vụ hoặc du lịch ): ");
                String carType = scanner.nextLine();
                Oto oto = new Oto(licensePlate, selectedManufacturer, year, owner, seatNumber, carType);
                vahicleService.addVehicle(oto);
                break;
            case 3:
                System.out.println("Nhập công suất: ");
                double power = Double.parseDouble(scanner.nextLine());
                Motorcycle motorcycle = new Motorcycle(licensePlate, selectedManufacturer, year, owner, power);
                vahicleService.addVehicle(motorcycle);
                break;
            default:
                System.out.println("Bạn nhập số lựa chọn k hợp lệ");
                break;
        }

    }

    private Manufacturer getSelectedManufacturer() {
        for (int i = 0; i < vahicleService.manufacturers().size(); i++) {
            System.out.println((i+1) + ". " + vahicleService.manufacturers().get(i));
        }
        int chooseManufacturer = Integer.parseInt(scanner.nextLine());
        Manufacturer selectedManufacturer = null;
        switch (chooseManufacturer) {
            case 1:
                selectedManufacturer = vahicleService.manufacturers().get(0);
                break;
            case 2:
                selectedManufacturer = vahicleService.manufacturers().get(1);
                break;
            case 3:
                selectedManufacturer = vahicleService.manufacturers().get(2);
                break;
            case 4:
                selectedManufacturer = vahicleService.manufacturers().get(3);
                break;
            default:
                System.out.println("Bạn nhập số lựa chọn không hợp lệ");
                break;
        }
        return selectedManufacturer;
    }

}
