package ss7_abstract_interface.bai_tap.interface_resizeable;

public class Circle extends Shape  {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void resize(double percent) {
        radius *= (1 + percent / 100);
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
}
