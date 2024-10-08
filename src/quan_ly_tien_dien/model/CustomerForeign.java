package quan_ly_tien_dien.model;

public class CustomerForeign extends Customer {

    private String nationality;


    public CustomerForeign(String customerCode, String name, String nationality) {
        super(customerCode, name);
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

    public String convertForeignToLine() {
        return this.getCustomerCode() + "," + this.getName() + "," + this.getNationality();
    }
}
