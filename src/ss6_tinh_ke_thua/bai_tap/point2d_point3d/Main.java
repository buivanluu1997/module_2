package ss6_tinh_ke_thua.bai_tap.point2d_point3d;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);
        point2D = new Point2D(2.0f,1.0f);
        System.out.println(point2D);
        point2D.setX(5.0f);
        System.out.println(point2D);
        System.out.println("-------------------------------------------");

        Point3D point3D = new Point3D();
        System.out.println(point3D);
        point3D = new Point3D(1.5f, 5.3f, 2.4f);
        System.out.println(point3D);
        point3D.setZ(4.0f);
        System.out.println(point3D);
        point2D.setX(2.0f);
        System.out.println(point3D);
        System.out.println(point2D);
        System.out.println("-----------------------------");
        point3D.getXYZ();
        for (float item : point3D.getXYZ()) {
            System.out.print(item + " ");
        }
    }
}
