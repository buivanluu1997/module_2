package quan_ly_tien_dien.model;

public class Bill {
    private static int idCounter = 1;
    private String billId;
    private Customer customer;
    private String invoiceDate;
    private int quantity;
    private double price;
    private double intoMoney;

    public Bill(String billId, Customer customer, String invoiceDate, int quantity, double price, double intoMoney) {
        this.billId = billId;
        this.customer = customer;
        this.invoiceDate = invoiceDate;
        this.quantity = quantity;
        this.price = price;
        this.intoMoney = intoMoney;
    }

    public Bill(Customer customer, String invoiceDate, int quantity, double price) {
        this.billId = getBillId();
        this.customer = customer;
        this.invoiceDate = invoiceDate;
        this.quantity = quantity;
        this.price = price;

        if (customer instanceof CustomerVietNam) {
            CustomerVietNam customerVietNam = (CustomerVietNam) customer;
            double norm = customerVietNam.getNorm();
            if (quantity <= norm) {
                this.intoMoney = quantity * price;
            } else {
                double exceedNorm = quantity - norm;
                this.intoMoney = (price * norm) + (exceedNorm * price * 2.5);
            }
        } else if (customer instanceof CustomerForeign) {
            this.intoMoney = quantity * price;
        }
    }


    public String getBillId() {
        return String.format("MHD-%03d", idCounter++);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Hoá đơn{" +
                "mã hoá đơn: " + this.billId + '\'' +
                ", mã khách hàng: " + customer.getCustomerCode() +
                ", ngày ra hoá đơn: " + invoiceDate +
                ", số lượng: " + quantity +
                ", đơn giá: " + price +
                ", thành tiền: " + intoMoney +
                '}';
    }

    public String convertBillToLine() {
        return this.billId + "," + this.customer.getCustomerCode() + "," + this.invoiceDate + ","
                + this.quantity + "," + this.price + "," + this.intoMoney;
    }
}
