package ss7_abstract_interface.bai_tap.interface_resizeable;

public class Rectangle extends Shape implements Resizeable{
    protected double width;
    protected double height;

    public Rectangle()
    {
     this.width = 0 ;
     this.height = 0;
    }
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }


    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{width=" + width + ", height=" + height + ", Area = " + getArea() + "}";
    }

    @Override
    public void resize(double parcent) {
      width *= (1 + (parcent / 100));
      height *= (1 + (parcent / 100));
    }
}
