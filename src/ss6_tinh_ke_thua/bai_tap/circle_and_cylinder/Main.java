package ss6_tinh_ke_thua.bai_tap.circle_and_cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(2, "red");
        System.out.println(circle);
        circle.setRadius(3);
        System.out.println(circle);
        circle.setColor("blue");
        System.out.println(circle);
        System.out.println("-------------------------------------------------------------");

        Cylinder cylinder = new Cylinder(1, "while", 3);
        System.out.println(cylinder);
        System.out.println("height = " + cylinder.getHeight());
        cylinder.setHeight(5);
        System.out.println(cylinder);
    }
}
