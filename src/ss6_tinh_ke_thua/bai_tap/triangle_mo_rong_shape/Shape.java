package ss6_tinh_ke_thua.bai_tap.triangle_mo_rong_shape;

public class Shape {
    protected String color = "white";
    protected boolean filled = false;

    public Shape() {
    }
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    @Override
    public String toString() {
        return "Shape {color = " + getColor() + ", " + (filled ? "true" : "false");
    }
}
