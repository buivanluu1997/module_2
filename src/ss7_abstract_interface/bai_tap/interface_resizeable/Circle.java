package ss7_abstract_interface.bai_tap.interface_resizeable;

public class Circle extends Shape implements Resizeable{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius + ", Area = " + getArea() +
                '}';
    }

    @Override
    public void resize(double parcent) {
        radius *= (1 + parcent / 100);
    }
}
