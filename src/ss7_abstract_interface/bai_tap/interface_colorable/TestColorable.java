package ss7_abstract_interface.bai_tap.interface_colorable;

import ss6_tinh_ke_thua.thuc_hanh.Circle;
import ss6_tinh_ke_thua.thuc_hanh.Rectangle;
import ss6_tinh_ke_thua.thuc_hanh.Shape;
import ss6_tinh_ke_thua.thuc_hanh.Square;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2.0);
        shapes[1] = new Rectangle(2.0, 3.0);
        shapes[2] = new Square(4.0);

        for (Shape shape : shapes) {
            System.out.println(shape.Area());
        }

        for (Shape shape : shapes) {
            if (shape instanceof Colorable) {
               ((Colorable) shape).howToColor();
            }
        }
    }
}
