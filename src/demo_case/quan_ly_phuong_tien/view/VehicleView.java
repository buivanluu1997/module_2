package demo_case.quan_ly_phuong_tien.view;

import demo_case.quan_ly_phuong_tien.controller.CarController;
import demo_case.quan_ly_phuong_tien.controller.MotorcycleController;
import demo_case.quan_ly_phuong_tien.controller.TruckController;
import demo_case.quan_ly_phuong_tien.model.Car;
import demo_case.quan_ly_phuong_tien.model.Manufacturer;
import demo_case.quan_ly_phuong_tien.model.Motorcycle;
import demo_case.quan_ly_phuong_tien.model.Truck;
import demo_case.quan_ly_phuong_tien.repository.ManufacturerRepo;

import java.util.List;
import java.util.Scanner;

public class VehicleView {
    private CarController carController = new CarController();
    private TruckController truckController = new TruckController();
    private MotorcycleController motorcycleController = new MotorcycleController();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("Quản lí phương tiện giao thông \n" +
                    "Chọn chức năng: \n" +
                    "1. Thêm phương tiện \n" +
                    "2. Hiển thị phương tiện \n" +
                    "3. Xoá phương tiện \n" +
                    "4. Tìm kiếm theo biển kiểm soát");

            try {
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("---------------------------Thêm phương tiện---------------------------");
                        addVehicle();
                        break;
                    case 2:
                        System.out.println("---------------------------Hiển thị phương tiện---------------------------");
                        showVehicle();
                        break;
                    case 3:
                        System.out.println("---------------------------Xoá phương tiện---------------------------");
                        deleteVehicle();
                        break;
                    case 4:
                        System.out.println("---------------------------Tìm phương tiện---------------------------");
                        searchVehicle();
                        break;
                    case 5:
                        System.exit(0);

                }

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: bạn nhập không phải là số nguyên");
            }
        }
    }

    private void searchVehicle() {
        System.out.println("Nhập biển số cần tìm:");
        String licensePlate = scanner.nextLine();
        Truck truck = truckController.findByLicensePlate(licensePlate);
        Car car = carController.findByLicensePlate(licensePlate);
        Motorcycle motorcycle = motorcycleController.findByLicensePlate(licensePlate);

        if (truck == null && car == null && motorcycle == null) {
            System.out.println("Không tìm thấy phương tiện");
        } else {
            if (truck != null) {
                Truck truck1 = truckController.findByLicensePlate(licensePlate);
                System.out.println(truck1.displayInfo());

            }
            if (car != null) {
                Car car1 = carController.findByLicensePlate(licensePlate);
                System.out.println(car1.displayInfo());
            }
            if (motorcycle != null) {
                Motorcycle motorcycle1 = motorcycleController.findByLicensePlate(licensePlate);
                System.out.println(motorcycle1.displayInfo());
            }
        }
    }

    private void deleteVehicle() {
        System.out.println("Nhập biển kiểm soát cần xoá: ");
        String licensePlate = scanner.nextLine();
        Truck truck = truckController.findByLicensePlate(licensePlate);
        Car car = carController.findByLicensePlate(licensePlate);
        Motorcycle motorcycle = motorcycleController.findByLicensePlate(licensePlate);

        if (truck == null && car == null && motorcycle == null) {
            System.out.println("Phương tiện không tồn tại");
        } else {
            System.out.println("Bạn thật sự muốn xoá hay không? \n" +
                    "1. Có \n" +
                    "2. Không");
            int choose4 = Integer.parseInt(scanner.nextLine());
            if (choose4 == 1) {
                if (truck != null) {
                    truckController.delete(truck);
                }
                if (car != null) {
                    carController.delete(car);
                }
                if (motorcycle != null) {
                    motorcycleController.delete(motorcycle);
                }
                System.out.println("Bạn đã xoá thành công");
            } else {
                System.out.println("Đóng");
            }
        }
    }

    private void showVehicle() {
        System.out.println("Chọn phương tiện để hiển thị: \n" +
                "1. Xe tải \n" +
                "2. Xe ô tô \n" +
                "3. Xe máy");
        try {
            int choose2 = Integer.parseInt(scanner.nextLine());

            switch (choose2) {
                case 1:
                    System.out.println("---------------Xe tải---------------");
                    List<Truck> truckList = truckController.findAll();
                    for (Truck truck : truckList) {
                        System.out.println(truck.displayInfo());
                    }
                    break;
                case 2:
                    System.out.println("---------------Xe ô tô---------------");
                    List<Car> carList = carController.findAll();
                    for (Car car : carList) {
                        System.out.println(car.displayInfo());
                    }
                    break;
                case 3:
                    System.out.println("---------------Xe máy---------------");
                    List<Motorcycle> motorcycleList = motorcycleController.findAll();
                    for (Motorcycle motorcycle : motorcycleList) {
                        System.out.println(motorcycle.displayInfo());
                    }
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: bạn nhập không phải là số nguyên");
        }
    }

    private void addVehicle() {
        System.out.println("Chọn phương tiện cần thêm: \n" +
                "1. Thêm xe tải \n" +
                "2. Thêm xe ô tô \n" +
                "3. Thêm xe máy");
        int choose1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập biển kiểm soát cần thêm: ");
        String licensePlate = scanner.nextLine();
        System.out.println("Chọn hãng sản xuất: ");
        String manufacturerName = nameManufacturer();
        System.out.println("Nhập năm sản xuất: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập chủ sỡ hửu: ");
        String owner = scanner.nextLine();

        switch (choose1) {
            case 1:
                System.out.println("Nhập tải trọng:");
                double payload = Double.parseDouble(scanner.nextLine());

                Truck truck = new Truck(licensePlate, manufacturerName, year, owner, payload);
                truckController.add(truck);
                System.out.println("Đã thêm xe tải thành công");
                break;

            case 2:
                System.out.println("Nhập số chỗ ngồi: ");
                int numberSeats = Integer.parseInt(scanner.nextLine());
                System.out.println("Chọn kiểu xe: \n" +
                        "1. Du lịch \n" +
                        "2. Xe khách");
                int choose2 = Integer.parseInt(scanner.nextLine());
                String carType = "";
                switch (choose2) {
                    case 1:
                        carType = "du lịch";
                        break;
                    case 2:
                        carType = "xe khách";
                        break;
                    default:
                        System.out.println("Chọn ngoài 1-2 nên thoát");
                        break;
                }
                Car car = new Car(licensePlate, manufacturerName, year, owner, numberSeats, carType);
                carController.add(car);
                System.out.println("Đã thêm xe ô tô thành công");
                break;

            case 3:
                System.out.println("Nhập công suất xe máy: ");
                int capacity = Integer.parseInt(scanner.nextLine());

                Motorcycle motorcycle = new Motorcycle(licensePlate, manufacturerName, year, owner, capacity);
                motorcycleController.add(motorcycle);
                System.out.println("Đã thêm xe máy thành công");
                break;
        }
    }

    private String nameManufacturer() {
        List<Manufacturer> manufacturers = ManufacturerRepo.getManufacturerList();
        for (int i = 0; i < manufacturers.size(); i++) {
            System.out.println((i + 1) + ". " + manufacturers.get(i).toString());
        }
        int choose2 = Integer.parseInt(scanner.nextLine());
        String manufactureName = "";
        switch (choose2) {
            case 1:
                manufactureName = manufacturers.get(0).getName();
                break;
            case 2:
                manufactureName = manufacturers.get(1).getName();
                break;
            case 3:
                manufactureName = manufacturers.get(2).getName();
                break;
            default:
                System.out.println("Chọn ngoài 1-3 nên thoát");
        }
        return manufactureName;
    }

}
