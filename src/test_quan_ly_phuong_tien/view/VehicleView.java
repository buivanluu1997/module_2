package test_quan_ly_phuong_tien.view;

import test_quan_ly_phuong_tien.controller.CarController;
import test_quan_ly_phuong_tien.controller.MotorcycleController;
import test_quan_ly_phuong_tien.controller.TruckController;
import test_quan_ly_phuong_tien.model.Car;
import test_quan_ly_phuong_tien.model.Manufacturer;
import test_quan_ly_phuong_tien.model.Motorcycle;
import test_quan_ly_phuong_tien.model.Truck;
import test_quan_ly_phuong_tien.repository.ManufacturerRepository;

import java.util.List;
import java.util.Scanner;

public class VehicleView {
    private CarController carController = new CarController();
    private MotorcycleController motorcycleController = new MotorcycleController();
    private TruckController truckController = new TruckController();
    private ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
    private Scanner scanner = new Scanner(System.in);

    public void showVehicle() {
        while (true) {
            System.out.println("Chọn chức năng: \n" +
                    "1. Thêm mới phương tiện \n" +
                    "2. Hiển thị phương tiện \n" +
                    "3. Xoá phương tiện \n" +
                    "4. Tìm kiếm theo biển kiểm soát \n" +
                    "5. Thoát");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("<--------------------------Thêm mới phương tiện-------------------------->");
                    addNewVehicle();
                    break;
                case 2:
                    System.out.println("<--------------------------Hiển thị phương tiện-------------------------->");
                    displayVehicle();
                    break;
                case 3:
                    System.out.println("<--------------------------Xoá phương tiện-------------------------->");
                    deleteVehicle();
                    break;
                case 4:
                    System.out.println("<--------------------------Tìm theo biển kiểm soát-------------------------->");
                    searchVehicle();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Bạn phải chọn 1-5.");
            }
        }
    }

    private void searchVehicle() {
        System.out.println("Nhập biển kiểm soát cần tìm: ");
        String licensePlate = scanner.nextLine();
        Truck truck = truckController.findLicensePlate(licensePlate);
        Car car = carController.findLicensePlate(licensePlate);
        Motorcycle motorcycle = motorcycleController.findLicensePlate(licensePlate);
        if (truck == null && car == null && motorcycle == null) {
            System.out.println("Không tìm thấy phương tiện");
        } else {
            if (truck != null) {
                List<Truck> truckList = truckController.search(licensePlate);
                for (Truck truck1 : truckList) {
                    System.out.println(truck1);
                }
            }
            if (car != null) {
                List<Car> carList = carController.search(licensePlate);
                for (Car car1 : carList) {
                    System.out.println(car1);
                }

            }
            if (motorcycle != null) {
                List<Motorcycle> motorcycleList = motorcycleController.search(licensePlate);
                for (Motorcycle motorcycle1 : motorcycleList) {
                    System.out.println(motorcycle1);
                }
            }
        }
    }

    private void deleteVehicle() {
        System.out.println("Nhập biển kiểm soát cần xoá: ");
        String licensePlate = scanner.nextLine();
        Truck truck = truckController.findLicensePlate(licensePlate);
        Car car = carController.findLicensePlate(licensePlate);
        Motorcycle motorcycle = motorcycleController.findLicensePlate(licensePlate);

        if (truck == null && car == null && motorcycle == null) {
            System.out.println("Không tìm thấy phương tiện");
        } else {
            System.out.println("Bạn có muốn xoá hay không: \n" +
                    "1. Có \n" +
                    "2. Không");
            int choose2 = Integer.parseInt(scanner.nextLine());
            switch (choose2) {
                case 1:
                    if (truck != null) {
                        truckController.delete(truck);
                    }
                    if (car != null) {
                        carController.delete(car);
                    }
                    if (motorcycle != null) {
                        motorcycleController.delete(motorcycle);
                    }
                    System.out.println("Đã xoá thành công");
                    break;
                case 2:
                    System.out.println("Quay về màn hình chính");
                    break;
                default:
                    System.out.println("Bạn chọn ngoài 1-2 nên thoát.");
                    break;
            }

        }
    }

    private void displayVehicle() {
        System.out.println("Chọn phương tiện cần hiển thị: \n" +
                "1. Hiển thị xe tải \n" +
                "2. Hiển thị xe ô tô \n" +
                "3. Hiển thị xe máy");
        int choose2 = Integer.parseInt(scanner.nextLine());
        switch (choose2) {
            case 1:
                System.out.println("-------------Danh sách xe tải-------------");
                List<Truck> truckList = truckController.getAll();
                for (Truck truck : truckList) {
                    System.out.println(truck.displayInfo());
                }
                break;
            case 2:
                System.out.println("-------------Danh sách xe ô tô-------------");
                List<Car> carList = carController.getAll();
                for (Car car : carList) {
                    System.out.println(car.displayInfo());
                }
                break;
            case 3:
                System.out.println("-------------Danh sách xe máy-------------");
                List<Motorcycle> motorcycleList = motorcycleController.getAll();
                for (Motorcycle motorcycle : motorcycleList) {
                    System.out.println(motorcycle.displayInfo());
                }
                break;
            default:
                System.out.println("Bạn nhập ngoài 1-3 nên thoát.");
        }
    }

    private void addNewVehicle() {
        System.out.println("Chọn thêm loại phương tiện: \n" +
                "1. Thêm xe tải \n" +
                "2. Thêm ô tô \n" +
                "3. Thêm xe máy");
        int chooseVehicle = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập biển kiểm soát: ");
        String licensePlate = scanner.nextLine();
        System.out.println("Chọn hãng sản xuất: ");
        Manufacturer manufacturer = getManufacturer();
        System.out.println("Nhập năm sản xuất: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();

        switch (chooseVehicle) {
            case 1:
                System.out.println("Nhập tải trọng: ");
                double loadCapacity = Double.parseDouble(scanner.nextLine());
                Truck truck = new Truck(licensePlate, manufacturer, year, owner, loadCapacity);
                truckController.add(truck);
                break;
            case 2:
                System.out.println("Nhập số chỗ ngồi: ");
                int seatNumber = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập kiểu xe(du lịch hoặc xe khách): ");
                String carType = scanner.nextLine();
                Car car = new Car(licensePlate, manufacturer, year, owner, seatNumber, carType);
                carController.add(car);
                break;
            case 3:
                System.out.println("Nhập công suất: ");
                double power = Double.parseDouble(scanner.nextLine());
                Motorcycle motorcycle = new Motorcycle(licensePlate, manufacturer, year, owner, power);
                motorcycleController.add(motorcycle);
                break;
            default:
                System.out.println("Bạn nhập ngoài 1-3 nên thoát.");
        }
    }

    private Manufacturer getManufacturer() {
        List<Manufacturer> list = manufacturerRepository.manufactures;
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        int chooseManufacturer = Integer.parseInt(scanner.nextLine());
        Manufacturer manufacturer = null;
        switch (chooseManufacturer) {
            case 1:
                manufacturer = list.get(0);
                break;
            case 2:
                manufacturer = list.get(1);
                break;
            case 3:
                manufacturer = list.get(2);
                break;
            default:
                System.out.println("Bạn chọn số ngoài từ 1-3 nên thoát.");
                break;
        }
        return manufacturer;
    }
}
