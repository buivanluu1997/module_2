package ss7_abstract_interface.test_bt.resizeable;

import ss7_abstract_interface.test_bt.cac_loai_hinh.Circle;
import ss7_abstract_interface.test_bt.cac_loai_hinh.Rectangle;
import ss7_abstract_interface.test_bt.cac_loai_hinh.Shape;
import ss7_abstract_interface.test_bt.cac_loai_hinh.Square;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2.0);
        shapes[1] = new Rectangle(3.0, 4.0, "blue", true);
        shapes[2] = new Square(2.0,"red", true);
        System.out.println("dien tich truoc:");
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }
        System.out.println("dien tich sau:");

        double randomDouble = Math.random()*100;
        for (Shape shape : shapes) {
            if (shape instanceof Resizeable) {
                ((Resizeable) shape).resize(randomDouble);
                System.out.println(shape);
            }
        }
    }
}
