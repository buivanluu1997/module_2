package test_quan_ly_phuong_tien.model;

public class Manufacture {
    private String manufacturerId;
    private String manufacturerName;
    private String country;

    public Manufacture() {
    }

    public Manufacture(String manufacturerId, String manufacturerName, String country) {
        this.manufacturerId = manufacturerId;
        this.manufacturerName = manufacturerName;
        this.country = country;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Mã hãng: " + manufacturerId + ", tên hãng: " + manufacturerName + ", quốc gia: " + country;
    }
}
