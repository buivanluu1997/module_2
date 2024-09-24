package quan_ly_phuong_tien.model;

public class Oto extends Vehicle {
    private int seatNumber; //số chỗ ngồi
    private String carType; //kiểu xe

    public Oto(String licensePlate, Manufacturer manufacturer, int year, String owner, int seatNumber, String carType) {
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
