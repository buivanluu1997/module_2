package demo_case.quan_ly_phuong_tien.model;

public class Car extends Vehicle {
    private int numberSeat;
    public String carType;

    public Car(String licensePlate, String nameManufacturer, int year, String owner, int numberSeat , String carType) {
        super(licensePlate, nameManufacturer, year, owner);
        this.numberSeat = numberSeat;
        this.carType = carType;
    }

    public int getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(int numberSeat) {
        this.numberSeat = numberSeat;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String displayInfo() {
        return "Ô tô: " + super.toString() + ", số chỗ ngồi: " + numberSeat + ", loại xe: " + carType;
    }

    public String csvCar(){
        return super.csv() + "," + this.numberSeat + "," + this.carType;
    }
}
