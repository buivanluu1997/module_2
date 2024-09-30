package test_quan_ly_phuong_tien.model;

import case_study.quan_ly_phuong_tien.model.Manufacturer;

public class Car extends Vehicle{
    private int seatNumber;
    private String carType;

    public Car(String licensePlate, Manufacture manufacture, int year, String nguyễnVănBình, int seatNumber, String dịchVụ) {
    }

    public Car(String licensePlate, Manufacturer manufacturer, int year, String owner, int seatNumber, String carType) {
        super(licensePlate, manufacturer, year, owner);
        this.seatNumber = seatNumber;
        this.carType = carType;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String displayInfo() {
        return "Ô tô: " + super.toString() + ", số chỗ ngồi: " + seatNumber + ", kiểu xe: " + carType;
    }
}
