package test_quan_ly_tien_dien.model;

public class CustomerForeign extends Customer {
    private String country;

    public CustomerForeign(String customerId, String customerName, String country) {
        super(customerId, customerName);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String displayInfo() {
        return "KHNN: " + super.toString() + ", quốc gia: " + country;
    }

    public String csvCustomerForeign(){
        return super.csv() + "," + this.country;
    }
}
