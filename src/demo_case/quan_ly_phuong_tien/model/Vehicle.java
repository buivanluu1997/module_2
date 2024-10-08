package demo_case.quan_ly_phuong_tien.model;

public abstract class Vehicle {
    private String licensePlate;
    private String nameManufacturer;
    private int year;
    private String owner;

    public Vehicle(String licensePlate, String nameManufacturer, int year, String owner) {
        this.licensePlate = licensePlate;
        this.nameManufacturer = nameManufacturer;
        this.year = year;
        this.owner = owner;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getNameManufacturer() {
        return nameManufacturer;
    }

    public void setNameManufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public abstract String displayInfo();

    @Override
    public String toString() {
        return "Biển số xe: " + this.licensePlate + ",tên hãng xe: " + this.nameManufacturer + ", năm sản xuất:"
                + this.year + ", chủ sở hữu: " + this.owner;
    }

    public String csv() {
        return this.licensePlate + "," + this.nameManufacturer + "," + this.year + "," + this.owner;
    }
}
