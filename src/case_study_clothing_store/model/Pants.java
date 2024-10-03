package case_study_clothing_store.model;

public class Pants extends Product {
    private int waistSize;
    private int length;

    public Pants() {
    }

    public Pants(String id, String name, String brand, double price, int quantity, int waistSize, int length) {
        super(id, name, brand, price, quantity);
        this.waistSize = waistSize;
        this.length = length;
    }

    public int getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(int waistSize) {
        this.waistSize = waistSize;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String displayInfo() {
        return "Quần{ " + super.toString() + ", vòng eo: " + waistSize + " cm" + ", chiều dài: " + length + "cm" + " }";
    }

    public String convertPantsToLine() {
        return this.getId() + "," + this.getName() + "," + this.getBrand() + ","
                + this.getPrice() + "," + this.getQuantity() + ","
                + this.getWaistSize() + "," + this.getLength();
    }
}
