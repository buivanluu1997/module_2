package test_quan_ly_tien_dien.model;

public abstract class Customer {
    private String customerId;
    private String customerName;

    public Customer(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
        return "Mã khách hàng: " + this.customerId + ", tên khách hàng: " + this.customerName;
    }

    public String csv(){
        return this.customerId + "," + this.customerName;
    }
}
