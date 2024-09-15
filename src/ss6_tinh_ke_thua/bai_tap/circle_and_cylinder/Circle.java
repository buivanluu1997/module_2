package ss6_tinh_ke_thua.bai_tap.circle_and_cylinder;

public class Circle {
    protected double radius;
    protected String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle {" +
                "radius = " + radius + ", Area = " + getArea()
                + ", color = " + color +  "}";
    }
}
