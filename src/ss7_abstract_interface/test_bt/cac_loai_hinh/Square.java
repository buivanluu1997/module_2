package ss7_abstract_interface.test_bt.cac_loai_hinh;

import ss7_abstract_interface.test_bt.resizeable.Resizeable;

public class Square extends Rectangle implements Resizeable {

    public Square() {
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public String toString() {
        return "Square{size = " + getSide() + ", Area = " + getArea() + "}" ;
    }
}
