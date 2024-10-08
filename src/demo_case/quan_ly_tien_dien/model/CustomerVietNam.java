package demo_case.quan_ly_tien_dien.model;

public class CustomerVietNam extends Customer {
    private CustomerType customerType;
    private double norm;

    public CustomerVietNam(String customerCode, String customerName, CustomerType customerType, double norm) {
        super(customerCode, customerName);
        this.customerType = customerType;
        this.norm = norm;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public double getNorm() {
        return norm;
    }

    public void setNorm(double norm) {
        this.norm = norm;
    }

    @Override
    public String displayInfo() {
        return "KHVN: " + super.toString() + ", loại khách hàng: " + customerType + ", định mức: " + norm;
    }

    public String convertCustomerVietNamToLine(){
        return this.getCustomerCode() + "," + this.getCustomerName() + "," + this.customerType.getId()
                + "," + this.customerType.getName() + "," + this.getNorm();
    }
}
