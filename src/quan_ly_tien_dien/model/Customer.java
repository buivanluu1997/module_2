package quan_ly_tien_dien.model;

public abstract class Customer {
    private String customerCode;
    private String name;

    public Customer(String customerCode, String name) {
        this.customerCode = customerCode;
        this.name = name;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String displayInfo();

    @Override
    public String toString() {
        return "mã khách hàng: " + customerCode + ", họ và tên: " + name;
    }
}
