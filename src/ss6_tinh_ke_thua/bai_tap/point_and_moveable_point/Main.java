package ss6_tinh_ke_thua.bai_tap.point_and_moveable_point;

public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        point = new Point(1.0f, 2.0f);
        System.out.println(point);
        point.setX(3.0f);
        System.out.println(point);
        point.setXY(2.5f, 3.0f);
        System.out.println(point);
        System.out.println("float[] arr: ");
        for (int i = 0; i < point.getXY().length; i++) {
            System.out.print(point.getXY()[i] + " ");
        }
        System.out.println("\n----------------------------------------------------");
        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);
        moveablePoint = new MoveablePoint(1.0f, 2.0f);
        System.out.println(moveablePoint);
        moveablePoint = new MoveablePoint(1.0f, 2.0f, 2.5f, 3.0f);
        System.out.println(moveablePoint);
        moveablePoint.setYSpeed(2.0f);
        System.out.println(moveablePoint);
        moveablePoint.move();
        System.out.println(moveablePoint);

        Point p1 = new MoveablePoint();
        System.out.println(p1);
        MoveablePoint p2 = (MoveablePoint) p1;
        p2 = new MoveablePoint(2.0f, 3.0f, 4.0f, 5.0f);
        System.out.println(p2);
        System.out.println(p2.getYSpeed());

    }
}