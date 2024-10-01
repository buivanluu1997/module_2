package case_study.quan_ly_phuong_tien.view;

import case_study.quan_ly_phuong_tien.controller.CarController;
import case_study.quan_ly_phuong_tien.controller.MotorcycleController;
import case_study.quan_ly_phuong_tien.controller.TruckController;
import case_study.quan_ly_phuong_tien.model.Car;
import case_study.quan_ly_phuong_tien.model.Manufacturer;
import case_study.quan_ly_phuong_tien.model.Motorcycle;
import case_study.quan_ly_phuong_tien.model.Truck;
import case_study.quan_ly_phuong_tien.repository.ManufacturerRepository;
import case_study.quan_ly_phuong_tien.service.FileHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleView {
    private CarController carController = new CarController();
    private TruckController truckController = new TruckController();
    private MotorcycleController motorcycleController = new MotorcycleController();
    private Scanner scanner = new Scanner(System.in);
    private ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
    private FileHelper fileHelper = new FileHelper();

    public VehicleView(){
        motorcycleController.readFile();
        carController.readFile();
        truckController.readFile();
    }
    public void renderVehicleMenu() {
        while (true) {
            try {
                System.out.println("QUẢN LÍ PHƯƠNG TIỆN GIAO THÔNG \n" +
                        "Chọn Chức Năng: \n" +
                        "1. Thêm mới phương tiện \n" +
                        "2. Hiển thị phương tiện \n" +
                        "3. Xoá phương tiện \n" +
                        "4. Tìm kiếm theo biển kiểm soát \n" +
                        "5. Ghi dữ liệu ra file \n" +
                        "6. Thoát");
                int choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        System.out.println("<------------------------------Thêm mới phương tiện------------------------------>");
                        newAddVehicle();
                        break;
                    case 2:
                        System.out.println("<------------------------------Hiển thị phương tiện------------------------------>");
                        displaysVehicleTypes();
                        break;
                    case 3:
                        System.out.println("<-------------------------Xoá phương tiện theo biển kiểm soát------------------------->");
                        deleteVehicle();
                        break;
                    case 4:
                        System.out.println("<----------------------------Tìm kiếm theo biển kiểm soát---------------------------->");
                        searchLicensePlate();
                        break;
                    case 5:
                        System.out.println("<----------------------------Ghi dữ liệu ra file---------------------------->");
                        writeFile();
                        break;
                    case 6:
                        carController.writeFile();
                        motorcycleController.writeFile();
                        truckController.writeFile();
                        System.exit(0);
                }
            }catch (Exception e) {
                System.out.println("Phải chọn số nguyên.");
            }

        }
    }

    private void writeFile() {
        System.out.println("Chọn loại phương tiện cần ghi ra dữ liệu: \n" +
                "1. Xe ô tô \n" +
                "2. Xe máy \n" +
                "3. Xe Tải");
        int chooseVehicle = Integer.parseInt(scanner.nextLine());
        switch (chooseVehicle) {
            case 1:
                carController.writeFile();
                System.out.println("Đã ghi dữ liệu ô tô vào file thành công");
                break;
            case 2:
                motorcycleController.writeFile();
                System.out.println("Đã ghi dữ liệu xe máy vào file thành công");
                break;
            case 3:
                truckController.writeFile();
                System.out.println("Đã ghi dữ liệu xe tải vào file thành công");
                break;
            default:
                System.out.println("Bạn chọn số ngoài 1-3 nên thoát.");
        }
    }

    private void searchLicensePlate() {
        System.out.println("Nhập biển kiểm soát cần tìm: ");
        String inputLicensePlate = scanner.nextLine();
        Motorcycle motorcycle = motorcycleController.getByLicensePlate(inputLicensePlate);
        Truck truck = truckController.getByLicensePlate(inputLicensePlate);
        Car car = carController.getByLicensePlate(inputLicensePlate);
        if (motorcycle != null) {
            System.out.println(motorcycle.displayInfo());
        } else if (truck != null) {
            System.out.println(truck.displayInfo());
        } else if (car != null) {
            System.out.println(car.displayInfo());
        } else {
            System.out.println("Không tìm thấy phương tiện");
        }
    }

    private void deleteVehicle() {
        System.out.println("Nhập biển kiểm soát cần xoá: ");
        String inputLicensePlate = scanner.nextLine();

        Motorcycle motorcycle = motorcycleController.getByLicensePlate(inputLicensePlate);
        Truck truck = truckController.getByLicensePlate(inputLicensePlate);
        Car car = carController.getByLicensePlate(inputLicensePlate);
        if (motorcycle != null || truck != null || car != null) {
            System.out.println("Bạn chắc chắn xoá không? \n" +
                    "1. Có \n" +
                    "2. Không");
            int choose = Integer.parseInt(scanner.nextLine());
            if (choose == 1) {
                if (motorcycle != null) {
                    motorcycleController.delete(motorcycle);
                }
                if (truck != null) {
                    truckController.delete(truck);
                }
                if (carController != null) {
                    carController.delete(car);
                }
                System.out.println("Đã xoá thành công");
            } else {
                System.out.println("Đóng.");
            }
        } else {
            System.out.println("Không tìm thấy phương tiện");
        }
    }

    private void displaysVehicleTypes() {
        System.out.println("Chọn phương tiện để hiển thị: \n" +
                "1. Hiển thị xe tải \n" +
                "2. Hiển thị ô tô \n" +
                "3. Hiển thị xe máy");
        int chooseVehicle = Integer.parseInt(scanner.nextLine());
        switch (chooseVehicle) {
            case 1:
                for (Truck truck : truckController.getVehicles()) {
                    System.out.println(truck.displayInfo());
                }
                break;
            case 2:
                for (Car car : carController.getVehicles()) {
                    System.out.println(car.displayInfo());
                }
                break;
            case 3:
                for (Motorcycle motorcycle : motorcycleController.getVehicles()) {
                    System.out.println(motorcycle.displayInfo());
                }
                break;
            default:
                System.out.println("Bạn chọn số ngoài 1-3 nên không chọn được");
        }
    }

    private void newAddVehicle() {
        System.out.println("Chọn thêm mới phương tiện: \n" +
                "1. Thêm xe tải \n" +
                "2. Thêm ô tô \n" +
                "3. Thêm xe máy");
        int chooseVehicle = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập biển kiểm soát: ");
        String licensePlate = scanner.nextLine();
        System.out.println("Chọn hãng sản xuất có sẵn: ");
        Manufacturer newManufacturer = getManufacturer();
        System.out.println("Nhập năm sản xuất: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();

        switch (chooseVehicle) {
            case 1:
                System.out.println("Nhập tải trọng: ");
                double loadCapacity = Double.parseDouble(scanner.nextLine());
                Truck newTruck = new Truck(licensePlate, newManufacturer, year, owner, loadCapacity);
                truckController.addVehicle(newTruck);
                break;
            case 2:
                System.out.println("Nhập chỗ ngồi: ");
                int seatNumber = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập kiểu xe (du lịch hoặc xe khách): ");
                String carType = scanner.nextLine();
                Car car = new Car(licensePlate, newManufacturer, year, owner, seatNumber, carType);
                carController.addVehicle(car);
                break;
            case 3:
                System.out.println("Nhập công suất: ");
                double power = Double.parseDouble(scanner.nextLine());
                Motorcycle motorcycle = new Motorcycle(licensePlate, newManufacturer, year, owner, power);
                motorcycleController.addVehicle(motorcycle);
                break;
        }
    }

    private Manufacturer getManufacturer() {
        List<Manufacturer> list = manufacturerRepository.manufacturerList;
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        int chooseManufacturer = Integer.parseInt(scanner.nextLine());
        Manufacturer newManufacturer = null;
        switch (chooseManufacturer) {
            case 1:
                newManufacturer = list.get(0);
                break;
            case 2:
                newManufacturer = list.get(1);
                break;
            case 3:
                newManufacturer = list.get(2);
                break;
            default:
                System.out.println("Bạn chọn số ngoài từ 1-3 nên thoát.");
                break;
        }
        return newManufacturer;
    }
}



