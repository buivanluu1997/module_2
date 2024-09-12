package ss5_access_modifer_static_method_static_property.bai_tap.access_modified;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + ", Area = " + getArea()+
                '}';
    }
}
