package test_quan_ly_tien_dien.model;

public class CustomerVietNam extends Customer{
    private String customerType;
    private int norm;

    public CustomerVietNam(String customerId, String customerName, String customerType, int norm) {
        super(customerId, customerName);
        this.customerType = customerType;
        this.norm = norm;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public int getNorm() {
        return norm;
    }

    public void setNorm(int norm) {
        this.norm = norm;
    }

    @Override
    public String displayInfo() {
        return "KHVN: " + super.toString() + ", loại khách hàng: " + this.customerType + ", định mức: " + this.norm;
    }

    public String csvCustomerVietNam(){
        return super.csv() + "," + this.customerType + "," + this.norm;
    }
}
