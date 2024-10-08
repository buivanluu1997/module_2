package demo_case.quan_ly_phuong_tien.model;

public class Motorcycle extends Vehicle {
    private int capacity;

    public Motorcycle(String licensePlate, String nameManufacturer, int year, String owner, int capacity) {
        super(licensePlate, nameManufacturer, year, owner);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String displayInfo() {
        return "Xe máy: " + super.toString() + ", công suất: " + capacity;
    }

    public String csvMotorcycle() {
        return super.csv() + "," + this.capacity;
    }
}
