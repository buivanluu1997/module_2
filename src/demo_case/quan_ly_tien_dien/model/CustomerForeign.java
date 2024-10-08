package demo_case.quan_ly_tien_dien.model;

public class CustomerForeign extends Customer{
    private String nationality;

    public CustomerForeign(String customerCode, String customerName, String nationality) {
        super(customerCode, customerName);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String displayInfo() {
        return "KHNN: " + super.toString() + ", quốc tịch: " + nationality;
    }

    public String convertCustomerForeignToLine() {
        return this.getCustomerCode() + "," + this.getCustomerName() + "," + this.getNationality();
    }
}
