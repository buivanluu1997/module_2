package ss15_xu_li_ngoai_le_debug.bai_tap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Nhập các cạnh của tam giác: ");
            System.out.print("Nhập cạnh thứ nhất: ");
            double side1 = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập cạnh thứ hai: ");
            double side2 = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập cạnh thứ ba: ");
            double side3 = Double.parseDouble(scanner.nextLine());

            Triangle triangle = new Triangle(side1, side2, side3);
            System.out.println(triangle.toString());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Bạn hãy nhập số hợp lệ");

        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
