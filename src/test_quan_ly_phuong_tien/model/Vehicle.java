package test_quan_ly_phuong_tien.model;

import case_study.quan_ly_phuong_tien.model.Manufacturer;

public abstract class Vehicle {
    private String licensePlate;
    private Manufacturer manufacturer;
    private int year;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(String licensePlate, Manufacturer manufacturer, int year, String owner) {
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.year = year;
        this.owner = owner;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
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
        return "Biển kiểm soát: " + licensePlate + ", hãng sản xuất [ " + manufacturer + " ]"
                + ", năm sản xuất: " + year + ", chủ sở hữu: " + owner;
    }
}
