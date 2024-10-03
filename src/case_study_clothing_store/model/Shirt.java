package case_study_clothing_store.model;

public class Shirt extends Product{
    private String size;
    public String color;

    public Shirt(){
    }

    public Shirt(String size, String color) {
        this.size = size;
        this.color = color;
    }

    public Shirt(String id, String name, String brand, double price, int quantity, String size, String color) {
        super(id, name, brand, price, quantity);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String displayInfo() {
        return "Áo{ " + super.toString() + ", size áo: " + size + ", màu sắc: " + color + "}";
    }

    public String convertShirtToLine() {
        return this.getId() + "," + this.getName() + "," + this.getBrand() + "," + this.getPrice()
                + "," + this.getQuantity() + "," + this.getSize() + "," + this.getColor();
    }
}
