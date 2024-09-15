package ss6_tinh_ke_thua.thuc_hanh.test;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        Rectangle.filled = false;
        Rectangle.color = "while";
        System.out.println(rectangle);
        System.out.println(Rectangle.count);

        System.out.println(Rectangle.Area(2,4));
        Rectangle rectangle1 = new Rectangle(1,2);
        System.out.println(rectangle1);
        System.out.println(Rectangle.count);
    }
}
