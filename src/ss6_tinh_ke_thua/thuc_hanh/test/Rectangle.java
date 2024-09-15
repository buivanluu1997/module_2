package ss6_tinh_ke_thua.thuc_hanh.test;

public class Rectangle {
    static String color = "blue";
    static boolean filled = true;
    int width = 1;
    int height = 1;
    static int count = 1;

    public Rectangle() {
    }
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        count++;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static int Area(int width, int height) {
        return width * height;
    }
    @Override
    public String toString() {
        return "Rectangle: width = " + getWidth() + ", height = " + getHeight()
                + ", Area = " + Area(width, height) + ", color = " + color + ", filled = " + (filled ? "true" : "false");
    }
}
