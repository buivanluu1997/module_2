package demo_case.quan_ly_phuong_tien.model;

public class Truck extends Vehicle{
    private double payload;

    public Truck(String licensePlate, String nameManufacturer, int year, String owner, double payload) {
        super(licensePlate, nameManufacturer, year, owner);
        this.payload = payload;
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    @Override
    public String displayInfo() {
        return "Xe tải: " + super.toString() + ", trọng tải: " + this.payload ;
    }

    public String csvTruck(){
        return super.csv() + "," + this.payload;
    }
}
