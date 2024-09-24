package quan_ly_phuong_tien.model;

public class Truck extends Vehicle{
    private double loadCapacity; //trọng tải

    public Truck(String licensePlate, Manufacturer manufacturer, int year, String owner, double loadCapacity) {
        super(licensePlate, manufacturer, year, owner);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String displayInfo() {
        return "Xe tải: " + super.toString() + ", trọng tải: " + loadCapacity + " tấn.";
    }
}
