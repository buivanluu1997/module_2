package case_study_clothing_store.model;

public class Shoes extends Product{
    private int sizeShoes;
    private String material;

    public Shoes(){
    }

    public Shoes(int sizeShoes, String material) {
        this.sizeShoes = sizeShoes;
        this.material = material;
    }

    public Shoes(String id, String name, String brand, double price, int quantity, int sizeShoes, String material) {
        super(id, name, brand, price, quantity);
        this.sizeShoes = sizeShoes;
        this.material = material;
    }

    public int getSizeShoes() {
        return sizeShoes;
    }

    public void setSizeShoes(int sizeShoes) {
        this.sizeShoes = sizeShoes;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String displayInfo() {
        return "Giày{ " + super.toString() + ", size giày: " + sizeShoes + ", chất liệu: " + material + " }";
    }
}
