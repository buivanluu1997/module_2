package ss7_abstract_interface.test_bt.comparable;

import ss7_abstract_interface.test_bt.cac_loai_hinh.Circle;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       ComparableCircle1[] circle1s = new ComparableCircle1[3];
       circle1s[0] = new ComparableCircle1(3.0);
       circle1s[1] = new ComparableCircle1(1.0);
       circle1s[2] = new ComparableCircle1(2.0);

        System.out.println("truoc khi sap xep");
        for (ComparableCircle1 circle : circle1s) {
            System.out.println(circle);
        }

        Arrays.sort(circle1s);
        System.out.println("Sau khi sap xep");
        for (ComparableCircle1 circle : circle1s) {
            System.out.println(circle);
        }
    }
}
