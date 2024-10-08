package ss6_tinh_ke_thua.bai_tap.circle_and_cylinder;

public class Cylinder extends Circle{
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume() {
        return getRadius() * height;
    }

    @Override
    public String toString() {
        return "Cylinder { "+ super.toString() +
                ", height = " + getHeight() + ", Volume = " + getVolume() +
                '}';
    }
}
