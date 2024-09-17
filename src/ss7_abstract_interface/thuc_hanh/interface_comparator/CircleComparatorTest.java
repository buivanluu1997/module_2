package ss7_abstract_interface.thuc_hanh.interface_comparator;

import ss6_tinh_ke_thua.thuc_hanh.Circle;

import java.util.Arrays;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(2.0);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5, "black", true);

        System.out.println("Sap xep truoc: ");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        CircleComparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("Sau khi sap xep: ");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
