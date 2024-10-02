package test_quan_ly_phuong_tien.model;

public class Motorcycle extends Vehicle {
    private double power;


    public Motorcycle(String licensePlate, Manufacturer manufacturer, int year, String owner, double power) {
        super(licensePlate, manufacturer, year, owner);
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public String displayInfo() {
        return "Xe máy: " + super.toString() + ", công suất: " + power;
    }

    public String convertMotorcycleToLine () {
        return this.getLicensePlate() + "," + this.getManufacturer().getManufacturerId() + "," +
                this.getManufacturer().getManufacturerName() + "," + this.getManufacturer().getCountry() + "," +
                this.getYear() + "," + this.getOwner() + "," + this.getPower();
    }
}
