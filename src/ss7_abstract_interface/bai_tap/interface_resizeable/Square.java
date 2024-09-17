package ss7_abstract_interface.bai_tap.interface_resizeable;

public class Square extends Rectangle {

    public Square(double size) {
        this.width = size;
        this.height = size;
    }
    @Override
    public String toString() {
        return "Square { size = " + width + ", Area = " + getArea() + "}";
    }
}


