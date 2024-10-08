package demo_case.quan_ly_tien_dien.model;

public abstract class Customer {
    private String customerCode;
    private String customerName;

    public Customer(String customerCode, String customerName) {
        this.customerCode = customerCode;
        this.customerName = customerName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public abstract String displayInfo();

    @Override
    public String toString() {
        return "Ma khach hang: " + customerCode + ", ten khach hang: " + customerName;
    }
}
