package ss7_abstract_interface.test_bt.comparator;

import ss7_abstract_interface.test_bt.cac_loai_hinh.Circle;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(2.0);
        circles[1] = new Circle(1.0);
        circles[2] = new Circle(3.0);

        System.out.println("truoc khi sap xep");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
        System.out.println("Sau khi sap xep");

        CircleComparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
