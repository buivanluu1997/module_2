package quan_ly_tien_dien.model;

public class CustomerVietNam extends Customer {
    private CustomerType customerType;
    private double norm;

    public CustomerVietNam(String customerCode, String name, CustomerType customerType, double norm) {
        super(customerCode, name);
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
        return "KHVN: " + super.toString() + ", loại khách hàng: " + customerType
                + ", định mức tiêu thụ: " + norm;
    }

    public String convertKHVNToLine(){
        return this.getCustomerCode() + "," + this.getName() + "," + this.customerType.getId()
                + "," + this.customerType.getType() + "," + this.getNorm();
    }
}
